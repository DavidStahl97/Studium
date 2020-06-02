package de.thm.mdd.testapp.entities;

import java.lang.String;
import java.util.ArrayList;

/**
* This is the {@link Person} entity class.
*
*@generated
*/
public class PersonGen {

	// attributes
	private String name;
	private String wohnort;
	private String titel;

	// references
	private ArrayList<Veranstaltung> veranstaltung;

	/**
	* Default constructor.
	*/
	public PersonGen() {
	}

	/**
	* Constructor for all attributes.
	*/
	public PersonGen(String name, String wohnort, String titel) {
		this.name = name;
		this.wohnort = wohnort;
		this.titel = titel;
	}

	/**
	* Full constructor.
	*/
	public PersonGen(String name, String wohnort, String titel, ArrayList<Veranstaltung> veranstaltung) {
		this.name = name;
		this.wohnort = wohnort;
		this.titel = titel;
		this.veranstaltung = veranstaltung;
	}

	//TODO getter setter

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" - ");
		builder.append(wohnort);
		builder.append(" - ");
		builder.append(titel);
		builder.append(" - ");
		return builder.toString();
	}

}
