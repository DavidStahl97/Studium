package de.thm.schule.repository.access.interfaces;

import java.util.List;

import de.thm.schule.repository.IDataAccessObject;
import de.thm.schule.repository.entities.Teacher;

public interface ITeacherDataAccess extends IDataAccessObject<Teacher, Integer> {

	List<Teacher> byNachname(String nachname);
	
}
