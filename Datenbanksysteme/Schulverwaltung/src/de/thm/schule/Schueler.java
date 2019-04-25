package de.thm.schule;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("S")
public class Schueler extends Person {
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Klasse Klasse;
	
	@ManyToMany(mappedBy = "Schueler", cascade = CascadeType.PERSIST)
	private List<Arbeitsgruppe> AG;

	public List<Arbeitsgruppe> getArbeitsgruppe()
	{
		return AG;
	}
	
	public void setArbeitsgruppe(List<Arbeitsgruppe> ag)
	{
		AG = ag;
	}

	public Klasse getKlasse() {
		return Klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.Klasse = klasse;
	}

}
