package de.thm.schule;

import java.util.Date;

import de.thm.schule.Entity.Arbeitsgruppe;
import de.thm.schule.Entity.Klasse;
import de.thm.schule.Entity.Lehrer;
import de.thm.schule.Entity.Schueler;

public class DummyFactory {

	public static Lehrer createLehrer() {
		Lehrer lehrer = new Lehrer();
		lehrer.setVorname(getRandom(vornamen));
		lehrer.setNachname(getRandom(nachnamen));
		lehrer.setGeburtstag(createDate());
		lehrer.setEintritt(createDate());
		return lehrer;
	}

	public static Klasse createKlasse() {
		Klasse klasse = new Klasse();
		klasse.setBezeichnung(getRandom(klassen));
		return klasse;
	}

	public static Schueler createSchueler() {
		Schueler schueler = new Schueler();
		schueler.setVorname(getRandom(vornamen));
		schueler.setNachname(getRandom(nachnamen));
		schueler.setGeburtstag(createDate());
		schueler.setEintritt(createDate());
		return schueler;
	}

	public static Arbeitsgruppe createAG() {
		Arbeitsgruppe ag = new Arbeitsgruppe();
		ag.setBezeichnung(getRandom(ags));
		return ag;

	}
	
    private static Date createDate() {
        long millisecs = (long) (Math.random() * 1000000000000l);
        return new Date(millisecs);
    }

	private static String getRandom(String[] strings) {
		return strings[(int) (Math.random() * strings.length)];
	}

	private static final String[] vornamen = { "Kirk", "James", "Lars", "Robert", "Elvis", "Lemmy", "Bruce", "Tony" };
	private static final String[] nachnamen = { "Hammett", "Hetfield", "Ulrich", "Trujillo", "Presley", "Kilmister", "Dickinson", "Iommy" };
	private static final String[] ags = { "Gitarre", "Gesang", "Schlagzeug", "Bass", "Keyboard", "Triangel" };
	private static final String[] klassen = { "11a", "12b", "10c", "9d", "9e", "9a", "9z", "11b" };

}