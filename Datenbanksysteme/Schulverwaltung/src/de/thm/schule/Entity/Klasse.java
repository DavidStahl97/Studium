package de.thm.schule.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Klasse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int KNr;
	
	private String Bezeichnung;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Lehrer Lehrer;
	
	@OneToMany(mappedBy = "Klasse", cascade = CascadeType.PERSIST)
	private List<Schueler> Schueler;
	
	
	public List<Schueler> getSchueler()
	{
		return Schueler;
	}
	
	public void setSchueler(List<Schueler> Schueler)
	{
		this.Schueler = Schueler;
	}
	
	public Lehrer getKlassenlehrer() {
		return Lehrer;
	}

	public void setKlassenlehrer(Lehrer lehrer) {
		this.Lehrer = lehrer;
	}

	public String getBezeichnung() {
		return Bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.Bezeichnung = bezeichnung;
	}

}
