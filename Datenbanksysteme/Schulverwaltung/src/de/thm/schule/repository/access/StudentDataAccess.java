package de.thm.schule.repository.access;

import java.util.List;

import de.thm.schule.repository.JpaDataAccessObject;
import de.thm.schule.repository.access.interfaces.IStudentDataAccess;
import de.thm.schule.repository.entities.Student;

class StudentDataAccess extends JpaDataAccessObject<Student, Integer> implements IStudentDataAccess {

	// @NamedQuery(name = Student.SCHUELER_BY_KLASSE, query = "select s from Schueler s inner join s.Klasse k where k.Bezeichnung = :" + Student.SCHUELER_BY_KLASSE_BEZEICHNUNG)
	
	public void persist(List<Student> students) {
		
		var transaction = entityManager.getTransaction();
		transaction.begin();
		
		for(var s : students) {
			entityManager.persist(s);
		}
		
		transaction.commit();
	}
	
}
