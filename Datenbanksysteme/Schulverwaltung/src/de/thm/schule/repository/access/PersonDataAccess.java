package de.thm.schule.repository.access;

import java.util.List;

import javax.persistence.Query;

import de.thm.schule.repository.JpaDataAccessObject;
import de.thm.schule.repository.access.interfaces.IPersonDataAccess;
import de.thm.schule.repository.entities.Person;

class PersonDataAccess extends JpaDataAccessObject<Person, Integer> implements IPersonDataAccess {
	
	@Override
	public List<Person> byNachname(String nachname) {
		
		var select = "select p from Person p where p.Nachname = :name";
		
		var query = entityManager.createQuery(select);
		query.setParameter("name", nachname);
		
		return query.getResultList();
	}
	
	@Override
	public void udpateTest() {
		var person = entityManager.find(Person.class, 2);
		
		person.setFirstName("David");
		person.setLastName("Stahl");
		
		var transaction = entityManager.getTransaction();
		transaction.begin();
	
		
		transaction.commit();
	}
	
}
