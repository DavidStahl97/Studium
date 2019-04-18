package de.thm.schule;

import javax.persistence.*;

public class Schulverwaltung 
{
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public Schulverwaltung()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("THM");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}
	
	public void close() 
	{
		entityManager.close(); 
		entityManagerFactory.close();
	}
}
