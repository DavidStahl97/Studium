package de.thm.schule;

import javax.persistence.*;

@Entity
@DiscriminatorValue("L")
@NamedQuery(name = Lehrer.LEHRER_BY_NACHNAME, query = "select l from Lehrer l where l.Nachname = :name")
public class Lehrer extends Person {
	
	public static final String LEHRER_BY_NACHNAME = "LEHRER_BY_NACHNAME";
	
	@OneToOne(mappedBy = "Lehrer" ,cascade = CascadeType.PERSIST)
	private Klasse Klasse;
}
