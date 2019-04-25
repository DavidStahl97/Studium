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
		
		anlegen();
		
		verwaltung.close();
	}

	private static void anlegen() 
	{
		EntityTransaction tx = verwaltung.getEntityManager().getTransaction();
		tx.begin();
		
		Klasse klasse = DummyFactory.createKlasse();
		
		Lehrer lehrer = DummyFactory.createLehrer();
		klasse.setKlassenlehrer(lehrer);
		
		List<Arbeitsgruppe> ags = new ArrayList<Arbeitsgruppe>();
		ags.add(DummyFactory.createAG());
		ags.add(DummyFactory.createAG());
		
		for(int i = 0; i < 5; i++)
		{
			Schueler s = DummyFactory.createSchueler();
			s.setArbeitsgruppe(ags);
			s.setKlasse(klasse);
			verwaltung.getEntityManager().persist(s);
		}
		
		verwaltung.getEntityManager().persist(klasse);
		tx.commit();
	}
	

}
