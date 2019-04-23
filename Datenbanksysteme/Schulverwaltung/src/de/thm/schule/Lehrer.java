package de.thm.schule;

import javax.persistence.*;

@Entity
public class Lehrer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PNr;
	
	@OneToOne(mappedBy = "Lehrer")
	private Klasse Klasse;
	
	private String Nachname;
	private String Vorname;
	
	
	public int getPNr() {
		return PNr;
	}
	
	public void setPNr(int pNr) {
		PNr = pNr;
	}
	
	public String getNachname() {
		return Nachname;
	}
	
	public void setNachname(String nachname) {
		Nachname = nachname;
	}
	
	public String getVorname() {
		return Vorname;
	}
	
	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	
}
