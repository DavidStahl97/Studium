package de.thm.schule;

import java.util.ArrayList;

public class Klasse{


	private String bezeichnung;
	private Lehrer lehrer;
	private ArrayList<Schueler> schueler;

		public ArrayList<Schueler> getSchueler() {
		return schueler;
	}

	public void setSchueler(ArrayList<Schueler> schueler) {
		this.schueler = schueler;
	}

	public Lehrer getLehrer() {
		return lehrer;
	}

	public void setLehrer(Lehrer lehrer) {
		this.lehrer = lehrer;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}
