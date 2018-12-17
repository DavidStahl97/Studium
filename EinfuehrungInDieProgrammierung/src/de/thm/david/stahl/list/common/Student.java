package de.thm.david.stahl.list.common;

public class Student extends Person {
	private static int lastStudentID = 0;
	private int studentID;
	
	private static int getNextStudentID() {
		lastStudentID++;
		return lastStudentID;
	}

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
		this.studentID = getNextStudentID();
	}

	public int getStudentID() {
		return studentID;
	}

	@Override
	public String getID() {
		return "Student ID: " + getStudentID();
	}
}

