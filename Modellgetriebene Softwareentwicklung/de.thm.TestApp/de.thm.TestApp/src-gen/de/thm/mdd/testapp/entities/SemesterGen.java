package de.thm.mdd.testapp.entities;

import java.util.Date;
import java.lang.String;
import java.util.ArrayList;

/**
* This is the {@link Semester} entity class.
*
*@generated
*/
public class SemesterGen {

	// attributes
	private String name;
	private Date date;

	// references
	private ArrayList<Veranstaltung> veranstaltung;

	/**
	* Default constructor.
	*/
	public SemesterGen() {
	}

	/**
	* Constructor for all attributes.
	*/
	public SemesterGen(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	/**
	* Full constructor.
	*/
	public SemesterGen(String name, Date date, ArrayList<Veranstaltung> veranstaltung) {
		this.name = name;
		this.date = date;
		this.veranstaltung = veranstaltung;
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
