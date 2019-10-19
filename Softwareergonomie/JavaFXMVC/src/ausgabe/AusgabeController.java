package ausgabe;

public class AusgabeController {
    
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
	 
	    
	   class backBtnEventHandler implements EventHandler<actionevent>{
	 
	      @Override
	      public void handle(ActionEvent e) {   
	         // zur naechsten Seiten springen! 
	          EingabeVC eingabeVC = new EingabeVC(dataBean);
	          eingabeVC.show();   
	      }
	       
	   }
	}
