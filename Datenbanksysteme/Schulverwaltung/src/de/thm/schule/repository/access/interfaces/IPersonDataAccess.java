package de.thm.schule.repository.access.interfaces;

import java.util.List;

import de.thm.schule.repository.IDataAccessObject;
import de.thm.schule.repository.entities.Person;

public interface IPersonDataAccess extends IDataAccessObject<Person, Integer> {

	List<Person> byNachname(String nachname);
	
	void udpateTest();
}
