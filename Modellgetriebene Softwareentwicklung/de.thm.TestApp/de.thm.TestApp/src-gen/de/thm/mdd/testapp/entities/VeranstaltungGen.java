package de.thm.mdd.testapp.entities;

import java.lang.String;
import java.util.ArrayList;

/**
* This is the {@link Veranstaltung} entity class.
*
*@generated
*/
public class VeranstaltungGen {

	// attributes
	private String name;
	private int sws;

	// references
	private Semester semester;
	private ArrayList<Person> person;

	/**
	* Default constructor.
	*/
	public VeranstaltungGen() {
	}

	/**
	* Constructor for all attributes.
	*/
	public VeranstaltungGen(String name, int sws) {
		this.name = name;
		this.sws = sws;
	}

	/**
	* Full constructor.
	*/
	public VeranstaltungGen(String name, int sws, Semester semester, ArrayList<Person> person) {
		this.name = name;
		this.sws = sws;
		this.person = person;
		this.semester = semester;
	}

	//TODO getter setter

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" - ");
		return builder.toString();
	}

}
