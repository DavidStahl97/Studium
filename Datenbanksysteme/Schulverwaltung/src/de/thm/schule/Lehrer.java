package de.thm.schule;

import javax.persistence.*;

@Entity
@DiscriminatorValue("L")
public class Lehrer extends Person {
	
	@OneToOne(mappedBy = "Lehrer" ,cascade = CascadeType.PERSIST)
	private Klasse Klasse;
}
