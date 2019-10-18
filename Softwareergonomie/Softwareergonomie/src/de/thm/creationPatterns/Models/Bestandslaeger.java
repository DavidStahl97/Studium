package de.thm.creationPatterns.Models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;

public class Bestandslaeger extends Observable {

    private Hashtable<String, Product> table = new Hashtable<String, Product>();

    public void storeObject(Product p)
    {
        table.put(p.getId(), p);
    }

    public Product getProduct(String name)
    {
        CheckNotification();
        return table.remove(name);
    }

    public List<Product> getProducts()
    {
        CheckNotification();
        return new ArrayList<>(table.values());
    }

    private void CheckNotification()
    {
        if(table.size() == 0)
        {
            setChanged();
            notifyObservers();
        }
    }
}
