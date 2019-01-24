package de.thm.david.stahl.list.linked;

import de.thm.david.stahl.list.common.Student;

public class StudentListElement {
	/** Eigentlicher Inhalt (= ein Student-Objekt). */
	private Student student;
	
	/** Referenz auf das n�chste Element in der verketteten Liste. */
	private StudentListElement next;
	
	
	public StudentListElement(Student student) {
		this.student = student;
		this.next = null;
	}

	public StudentListElement getNext() {
		return next;
	}

	public void setNext(StudentListElement next) {
		this.next = next;
	}

	public Student getStudent() {
		return student;
	}
}
