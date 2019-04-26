package de.thm.schule.EntityDao;

import java.util.List;

import de.thm.schule.Entity.Person;
import de.thm.schule.dao.IDao;

public interface IPersonDao extends IDao<Person, Integer> {

	List<Person> byNachname(String nachname);
	
}
