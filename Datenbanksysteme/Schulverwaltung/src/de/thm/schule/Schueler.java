package de.thm.schule;

import javax.persistence.*;
import java.util.List;

@Entity
public class Schueler {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String Nachname;
	private String Vorname;
	
	@ManyToOne
	private Klasse Klasse;
	
	@ManyToMany(mappedBy = "Schueler")
	private List<AG> AG;
	


	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		this.Nachname = nachname;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		this.Vorname = vorname;
	}

	public Klasse getKlasse() {
		return Klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.Klasse = klasse;
	}

}
