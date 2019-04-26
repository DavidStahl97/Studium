package de.thm.schule.repository.access.interfaces;

import java.util.List;

import de.thm.schule.repository.IDataAccessObject;
import de.thm.schule.repository.entities.Student;

public interface IStudentDataAccess extends IDataAccessObject<Student, Integer> {

	void persist(List<Student> students);
	
}
