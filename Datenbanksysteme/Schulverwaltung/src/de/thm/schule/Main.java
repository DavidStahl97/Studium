package de.thm.schule;

import javax.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main 
{
	private static Schulverwaltung verwaltung;
	
	public static void main(String[] args)
	{
		verwaltung = new Schulverwaltung();
		
		//lehrerAnlegen();
		//lehrerAusgeben();
		//updateLehrer();
		
		anlegen();
		
		verwaltung.close();
	}
	
	private static void anlegen()
	{
		EntityTransaction tx = verwaltung.getEntityManager().getTransaction();
		tx.begin();
		
		Klasse klasse = new Klasse();
		klasse.setBezeichnung("1a");
		
		Lehrer lehrer = new Lehrer();
		lehrer.setNachname("Lehrer");
		lehrer.setVorname("Lustig");
		klasse.setKlassenlehrer(lehrer);
		
		List<Schueler> schueler = new ArrayList<Schueler>();
		
		AG ag = new AG();
		ag.setBezeichnung("Tutorium");
		ag.setSchueler(schueler);
		
		List<AG> agList = new ArrayList<AG>();
		agList.add(ag);
		
		Schueler s1 = new Schueler();
		s1.setNachname("Franz");
		s1.setVorname("Hanz");
		s1.setKlasse(klasse);
		s1.setAG(agList);
		schueler.add(s1);
		
		Schueler s2 = new Schueler();
		s2.setNachname("Franz");
		s2.setVorname("Hanz");
		s2.setKlasse(klasse);
		s2.setAG(agList);
		schueler.add(s2);
		
		klasse.setSchueler(schueler);
		
		verwaltung.getEntityManager().persist(klasse);
		
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
