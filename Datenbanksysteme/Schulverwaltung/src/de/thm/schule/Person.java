package de.thm.schule;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="PERSON_TYPE") 
public class Person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String Nachname;
	private String Vorname;
	
	@Temporal(TemporalType.DATE)
	private Date Geburtstag;
	
	@Temporal(TemporalType.DATE)
	private Date Eintritt;
	
	public Date getGeburtstag() {
		return Geburtstag;
	}

	public void setGeburtstag(Date geburtstag) {
		Geburtstag = geburtstag;
	}

	public Date getEintritt() {
		return Eintritt;
	}

	public void setEintritt(Date eintritt) {
		Eintritt = eintritt;
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
