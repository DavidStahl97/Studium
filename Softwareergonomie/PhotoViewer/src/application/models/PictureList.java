package application.models;

import java.beans.PropertyChangeSupport;

public class PictureList extends PropertyChangeSupport {
	
	private String name;
	
    public PictureList() {
		super("");
	}
    
    public void setName(String name)
    {
    	String oldValue = this.name;
    	this.name = name;
    	
    	this.firePropertyChange("name", oldValue, name);
    }

}

