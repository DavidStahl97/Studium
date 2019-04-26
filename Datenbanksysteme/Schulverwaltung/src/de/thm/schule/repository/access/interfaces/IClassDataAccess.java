package de.thm.schule.repository.access.interfaces;

import java.util.List;

import de.thm.schule.repository.IDataAccessObject;
import de.thm.schule.repository.entities.Class;

public interface IClassDataAccess extends IDataAccessObject<Class, Integer> {

	void persist(List<Class> classes);
}
