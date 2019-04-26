package de.thm.schule.EntityDao;

import java.util.List;

import de.thm.schule.Entity.Lehrer;
import de.thm.schule.dao.IDao;

public interface ILehrerDao extends IDao<Lehrer, Integer> {

	List<Lehrer> byNachname(String nachname);
	
}
