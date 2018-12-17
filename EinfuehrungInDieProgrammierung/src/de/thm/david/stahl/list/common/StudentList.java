package de.thm.david.stahl.list.common;

public interface StudentList {
	/** Wird als R�ckgabewert in der search-Methode verwendet. */
	public static final int NOT_FOUND = -1;
	
	/** Bef�llt die Datenstruktur mit Testdaten. */
	public void initTestData();
	
	/** L�scht alle Eintr�ge aus der Datenstruktur. */
	public void clear();
	
	/** Gibt alle Eintr�ge aus. */
	public void print();
	
	/** Sortiert alle Eintr�ge alphabetisch nach Nachnamen. */
	public void sort();
	
	/** F�gt ein neues Element in einer (zuvor) sortierten Liste an der richtigen Stelle ein. */
	public void insert(Student student);
	
	/** Sucht nach einem Studenten mit dem gegebenen Namen (Vor- und Nachname). */
	public int search(String fullname);
}
