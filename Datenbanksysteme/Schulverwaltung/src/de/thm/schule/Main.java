package de.thm.schule;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class Main 
{
	private static Schulverwaltung verwaltung;
	
	public static void main(String[] args)
	{
		verwaltung = new Schulverwaltung();
		
		// lehrerAnlegen();
		lehrerAusgeben();
		//updateLehrer();
		
		verwaltung.close();
	}
	
	private static void lehrerAnlegen()
	{
		EntityTransaction tx = verwaltung.getEntityManager().getTransaction();
		tx.begin();
		
		Lehrer lehrer = new Lehrer();
		lehrer.setVorname("David");
		lehrer.setNachname("Stahl");
		lehrer.setPNr(11);
		
		verwaltung.getEntityManager().persist(lehrer);
		
		tx.commit();
	}
	
	private static void lehrerAusgeben()
	{
		Lehrer s = verwaltung.getEntityManager().find(Lehrer.class, 11);
		System.out.println(s.getVorname() + " " + s.getNachname());
	}
	
	private static void updateLehrer()
	{
		EntityTransaction tx = verwaltung.getEntityManager().getTransaction();		
		tx.begin();
		
		Lehrer l = verwaltung.getEntityManager().find(Lehrer.class, 1); 
		l.setNachname("Hawking"); 
		l.setVorname("Stephen");
		verwaltung.getEntityManager().merge(l);
		
		tx.commit();
	}
}
