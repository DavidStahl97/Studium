package application.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javafx.scene.Node;

public class PictureListView implements PropertyChangeListener {
	
	public PictureListView(PropertyChangeSupport publisher)
	{
		publisher.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
		String name = (String)e.getNewValue();
		System.out.println(name);
	}
	
	public Node getRoot()
	{
		return null;
	}
	
}
