package de.thm.schule.EntityDao;

import java.util.List;

import javax.persistence.Query;

import de.thm.schule.Entity.Lehrer;
import de.thm.schule.Entity.Person;
import de.thm.schule.dao.JpaDao;

public class LehrerDao extends JpaDao<Lehrer, Integer> implements ILehrerDao {

	public List<Lehrer> byNachname(String nachname) {
		
		String select = "select l from Lehrer l where l.Nachname = :name";
		
		Query query = entityManager.createQuery(select);
		query.setParameter("name", nachname);
		
		return query.getResultList();
	}	
	
}
