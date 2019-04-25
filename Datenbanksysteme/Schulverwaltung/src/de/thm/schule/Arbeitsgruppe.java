package de.thm.schule;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AG")
public class Arbeitsgruppe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String Bezeichnung;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Schueler> Schueler;

	public String getBezeichnung() {
		return Bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.Bezeichnung = bezeichnung;
	}

	public List<Schueler> getSchueler() {
		return Schueler;
	}

	public void setSchueler(List<Schueler> schueler) {
		this.Schueler = schueler;
	}

}
