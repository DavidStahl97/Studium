package de.thm.schule;

import java.util.ArrayList;

public class AG {

	private String bezeichnung;
	private ArrayList<Schueler> schueler;

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public ArrayList<Schueler> getSchueler() {
		return schueler;
	}

	public void setSchueler(ArrayList<Schueler> schueler) {
		this.schueler = schueler;
	}

}
