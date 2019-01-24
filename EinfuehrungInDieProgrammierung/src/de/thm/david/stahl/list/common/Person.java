package de.thm.david.stahl.list.common;

public abstract class Person {
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public abstract String getID();

	@Override
	public String toString() {
		return getFullName() + " (" + getID() + ")";
	}
		
}