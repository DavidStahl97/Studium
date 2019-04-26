package de.thm.schule.EntityDao;

import java.util.List;

import javax.persistence.Query;

import de.thm.schule.Entity.Person;
import de.thm.schule.dao.JpaDao;

public class PersonDao extends JpaDao<Person, Integer> implements IPersonDao {
	
	@Override
	public List<Person> byNachname(String nachname) {
		
		String select = "select p from Person p where p.Nachname = :name";
		
		Query query = entityManager.createQuery(select);
		query.setParameter("name", nachname);
		
		return query.getResultList();
	}
	
}
