package de.thm.schule;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class Main 
{
	private static Schulverwaltung verwaltung;
	
	public static void main(String[] args) 
	{
		verwaltung = new Schulverwaltung();
		
		anlegen();
		showLehrer("Hammett");
		showLehrer("Dickinson");
		
		verwaltung.close();
	}

	private static void showLehrer(String nachname) 
	{
		Query query = verwaltung.getEntityManager().createNamedQuery(Lehrer.LEHRER_BY_NACHNAME);
		query.setParameter("name", nachname);
		
		List<Lehrer> list = query.getResultList();
		for(Lehrer l : list)
		{
			System.out.println(l);
		}
	}

	private static void anlegen() 
	{
		EntityTransaction tx = verwaltung.getEntityManager().getTransaction();
		tx.begin();
		
		for(int i = 0; i < 10; i++)
		{			
			Klasse klasse = DummyFactory.createKlasse();
			
			Lehrer lehrer = DummyFactory.createLehrer();
			klasse.setKlassenlehrer(lehrer);
			
			List<Arbeitsgruppe> ags = new ArrayList<Arbeitsgruppe>();
			ags.add(DummyFactory.createAG());
			ags.add(DummyFactory.createAG());
			
			for(int j = 0; j < 20; j++)
			{
				Schueler s = DummyFactory.createSchueler();
				s.setArbeitsgruppe(ags);
				s.setKlasse(klasse);
				verwaltung.getEntityManager().persist(s);
			}
			
			verwaltung.getEntityManager().persist(klasse);
		}
		
		
		tx.commit();
	}
}
