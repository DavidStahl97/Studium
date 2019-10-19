package com.thm.javafxmvc.ausgabe;

import com.thm.javafxmvc.eingabe.EingabeVC;
import com.thm.javafxmvc.model.DataBean;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Steuert alle Interaktionen der Ausgabe-Maske
 * Verbindet die View mit dem Model
 * 
 * @author Alexander Gr.
 * @see http://blog.axxg.de
 *
 */
public class AusgabeVC {
	
	private DataBean dataBean;
	private AusgabeView view;
	
	
	public AusgabeVC(DataBean dataBean) {
		this.dataBean = dataBean;
		this.view = new AusgabeView();
		
		// Eventhandler registrieren
		view.getBackBtn().setOnAction(new backBtnEventHandler());	
	}
	
	public void show(){
		// View mit Daten befuellen
		int anz = 1;
		for (String key : dataBean.getNamePwMap().keySet()) {
			// 1: Name, Vorname
			view.getList().getItems().add(anz + ": " + key + ", " + dataBean.getNamePwMap().get(key));
			anz++;
		}		
		
		// View anzeigen
		view.show(dataBean.getPrimaryStage());
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++
	// Events
	//+++++++++++++++++++++++++++++++++++++++++++++

	
	class backBtnEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {	
			// zur naechsten Seiten springen! 
	    	EingabeVC eingabeVC = new EingabeVC(dataBean);
	    	eingabeVC.show();   
		}
		
	}
}
