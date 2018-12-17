package de.thm.david.stahl.list.linked;

import de.thm.david.stahl.list.common.*;

public class StudentLinkedList implements StudentList {
	
	/** "Kopf" (= Anfang) der Liste. */
	private StudentListElement head;
	private int noOfElements;
	
	public StudentLinkedList() {
		head = new StudentListElement(null);
		noOfElements = 0;
	}
	

	@Override
	public void initTestData() {
		noOfElements = TestData.LASTNAMES.length;
		
		StudentListElement predecessor = head;
		for (int i = 0; i < noOfElements; i++) {
			// Neuen Datensatz anlegen und f�llen
			StudentListElement newElement = new StudentListElement(new Student("Max", TestData.LASTNAMES[i]));
			
			// Neuen Datensatz verlinken
			predecessor.setNext(newElement);
			predecessor = newElement;
		}
	}

	@Override
	public void clear() {
		head.setNext(null);
		noOfElements = 0;
	}

	@Override
	public void print() {
		System.out.println(noOfElements + " Eintraege");
		
		StudentListElement e = head.getNext();
		while (e != null) {
			System.out.println(e.getStudent().toString());
			e = e.getNext();
		}

	}

	@Override
	public void sort() {
		// einfache Variante von Bubble-Sort
		for (int i = noOfElements - 1; i > 0; i--) {
			// Schleifen-Invariante: rechts von i ist alles sortiert
			StudentListElement e = head;
			for (int j = 0; j < i; j++) {
				StudentListElement first = e.getNext();
				StudentListElement second = first.getNext();
				if (first.getStudent().getLastName().compareTo(second.getStudent().getLastName()) > 0) {
					// Vertauschen durch 'Umbiegen' der Zeiger
					e.setNext(second);
					first.setNext(second.getNext());
					second.setNext(first);
				}
				e = e.getNext();
			} 
		}
	}

	@Override
	public void insert(Student student) {
		// Speicherplatz um 1 erh�hen
		noOfElements++;
		StudentListElement newElement = new StudentListElement(student);
				
		// richtige Stelle suchen
		StudentListElement e = head;
		while (e.getNext() != null) {
			if (student.getLastName().compareTo(e.getNext().getStudent().getLastName()) <= 0) break;
			e = e.getNext();
		}
		
		// neues Element platzieren
		newElement.setNext(e.getNext());
		e.setNext(newElement);
	}

	@Override
	public int search(String fullname) {
		// lineare Suche
		int noOfComparisons = 0;
		int result = StudentList.NOT_FOUND;
		StudentListElement e = head.getNext();
		for (int i = 0; i < noOfElements; i++, e = e.getNext()) {
			noOfComparisons++;
			if (e.getStudent().getFullName().equals(fullname)) {
				result = i;
				break;
			}
		}
		System.out.print("[lineare Suche: " + noOfComparisons + " Vergleiche]");
		return result;
	}

	public Student removeFirstStudent()
	{
		StudentListElement first = head.getNext();
		StudentListElement seoond = first.getNext();

		head.setNext(seoond);
		return first.getStudent();
	}

}
