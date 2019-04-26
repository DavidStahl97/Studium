package de.thm.schule.Entity;

import javax.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("S")
@NamedQuery(name = Schueler.SCHUELER_BY_KLASSE, query = "select s from Schueler s inner join s.Klasse k where k.Bezeichnung = :" + Schueler.SCHUELER_BY_KLASSE_BEZEICHNUNG)
public class Schueler extends Person {
	
	public static final String SCHUELER_BY_KLASSE = "SCHUELER_BY_KLASSE";
	public static final String SCHUELER_BY_KLASSE_BEZEICHNUNG = "bezeichnung";
	
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
	
	 @Override
	public String toString() {
		return super.toString() + ", Klasse: " + Klasse.getBezeichnung();
	}
}
