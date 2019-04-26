package de.thm.schule.dao;

import java.io.Serializable;

public interface IDao<E, PK extends Serializable> {

	public void persist(E entity);
	
	public void remove(E entity);
	
	public E findById(PK id);
	
}
