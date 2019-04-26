package de.thm.schule.repository.access;

import java.util.List;

import javax.persistence.Query;

import de.thm.schule.repository.JpaDataAccessObject;
import de.thm.schule.repository.access.interfaces.ITeacherDataAccess;
import de.thm.schule.repository.entities.Teacher;

class TeacherDataAccess extends JpaDataAccessObject<Teacher, Integer> implements ITeacherDataAccess {

	public List<Teacher> byNachname(String nachname) {
		
		String select = "select l from Lehrer l where l.Nachname = :name";
		
		Query query = entityManager.createQuery(select);
		query.setParameter("name", nachname);
		
		return query.getResultList();
	}
	
}
