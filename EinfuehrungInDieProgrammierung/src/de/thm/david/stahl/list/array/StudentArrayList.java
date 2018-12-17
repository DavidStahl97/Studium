package de.thm.david.stahl.list.array;

import de.thm.david.stahl.list.common.Student;
import de.thm.david.stahl.list.common.StudentList;
import de.thm.david.stahl.list.common.TestData;

public class StudentArrayList implements StudentList {
	
	/** Das eigentliche Feld, das alle Eintr�ge enth�lt. */
	private Student[] students;
	
	/** Gibt an, ob das Feld sortiert ist. */
	private boolean sorted;
	
	public StudentArrayList() {
		clear();
	}

	@Override
	public void initTestData() {
		sorted = false;
		students = new Student[TestData.LASTNAMES.length];
		for (int i = 0; i < TestData.LASTNAMES.length; i++) {
			students[i] = new Student("Max", TestData.LASTNAMES[i]);
		}
	}

	@Override
	public void clear() {
		students = new Student[0];
		sorted = true;
	}

	@Override
	public void print() {
		System.out.println(students.length + " Eintraege");
		for (Student s : students) System.out.println(s.toString());
	}

	@Override
	public void sort() {		
		if (sorted) return;
		sorted = true;
		
		// einfache Variante von Bubble-Sort
		for (int i = students.length - 1; i > 0; i--) {
			// Schleifen-Invariante: rechts von i ist alles sortiert
			for (int j = 0; j < i; j++) {
				if (students[j].getLastName().compareTo(students[j+1].getLastName()) > 0) swap(j, j+1);
			}
		}
	}

	/** Hilfsfunktion f�r die sort-Methode. */
	private void swap(int i, int j) {
		Student tmp = students[i];
		students[i] = students[j];
		students[j] = tmp;
	}

	@Override
	public void insert(Student student) {
		// Speicherplatz um 1 erh�hen
		Student[] biggerArray = new Student[students.length+1];
		for (int i = 0; i < students.length; i++) biggerArray[i] = students[i];
		students = biggerArray;
		
		// richtige Stelle suchen
		int i = 0;
		for (; i < students.length-1; i++) {
			if (student.getLastName().compareTo(students[i].getLastName()) <= 0) break;
		}
		// alte Elemente nach rechts schieben, um Platz zu schaffen
		for (int j = students.length - 1; j > i; j--) {
			students[j] = students[j-1];
		}
		// neues Element platzieren
		students[i] = student;
	}

	@Override
	public int search(String fullname) {
		if (sorted) {
			return binarySearch(fullname);
		} else {
			return linearSearch(fullname);
		}
	}
	
	public int linearSearch(String fullname) {
		int noOfComparisons = 0;
		int result = StudentList.NOT_FOUND;
		for (int i = 0; i < students.length; i++) {
			noOfComparisons++;
			if (students[i].getFullName().equals(fullname)) {
				result = i;
				break;
			}
		}
		System.out.print("[lineare Suche: " + noOfComparisons + " Vergleiche]");
		return result;
	}
	
	public int binarySearch(String fullname) {
		int noOfComparisons = 0;
		int result = StudentList.NOT_FOUND;
		int left = 0;
		int right = students.length - 1;
		while (left <= right) {
			noOfComparisons++;
			int middle = (left + right) / 2;
			int comparison = fullname.compareTo(students[middle].getFullName());
			if (comparison == 0) {
				result = middle;
				break;
			} else if (comparison < 0) {
				right = middle-1;
			} else {
				left = middle+1;
			}
		}
		
		System.out.print("[binaere Suche: " + noOfComparisons + " Vergleiche]");
		return result;
	}

	public Student removeFirstStudent()
	{
		if(students.length == 0)
		{
			return null;
		}

		Student firstStudent = students[0];

		Student[] newList = new Student[students.length - 1];
		for(int i = 0; i < newList.length; i++)
		{
			newList[i] = students[i + 1];
		}

		students = newList;

		return firstStudent;
	}
}
