package de.thm.schule;

import java.util.ArrayList;

public class Schueler {

	private String nachname;
	private String vorname;
	private Klasse klasse;
	private ArrayList<AG> ags;

	public ArrayList<AG> getAgs() {
		return ags;
	}

	public void setAgs(ArrayList<AG> ags) {
		this.ags = ags;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

}
