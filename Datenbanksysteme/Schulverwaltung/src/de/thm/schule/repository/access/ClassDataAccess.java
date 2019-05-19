package de.thm.schule.repository.access;

import java.util.List;

import de.thm.schule.repository.JpaDataAccessObject;
import de.thm.schule.repository.entities.Class;
import de.thm.schule.repository.access.interfaces.IClassDataAccess;

class ClassDataAccess extends JpaDataAccessObject<Class, Integer> implements IClassDataAccess {
	
	public void persist(List<Class> classes) {
		
		var transaction = entityManager.getTransaction();
		transaction.begin();
		
		for(var c : classes) {			
			entityManager.persist(c);			
		}
		
		transaction.commit();
	}

}
