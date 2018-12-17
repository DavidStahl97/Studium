package de.thm.david.stahl.list.common;

public interface StudentList {
	/** Wird als R�ckgabewert in der search-Methode verwendet. */
	int NOT_FOUND = -1;
	
	/** Bef�llt die Datenstruktur mit Testdaten. */
	void initTestData();
	
	/** L�scht alle Eintr�ge aus der Datenstruktur. */
	void clear();
	
	/** Gibt alle Eintr�ge aus. */
	void print();
	
	/** Sortiert alle Eintr�ge alphabetisch nach Nachnamen. */
	void sort();
	
	/** F�gt ein neues Element in einer (zuvor) sortierten Liste an der richtigen Stelle ein. */
	void insert(Student student);
	
	/** Sucht nach einem Studenten mit dem gegebenen Namen (Vor- und Nachname). */
	int search(String fullname);

	Student removeFirstStudent();
}
