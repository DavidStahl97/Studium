package de.thm.schule;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Lehrer{
	
	@Id
	private int PNr;
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
