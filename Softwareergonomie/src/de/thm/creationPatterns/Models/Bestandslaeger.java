package de.thm.creationPatterns.Models;

import java.util.Hashtable;

public class Bestandslaeger {

    private Hashtable<String, Product> table = new Hashtable<String, Product>();

    public void storeObject(Product p)
    {
        table.put(p.getId(), p);
    }

    public Product getProduct(String name)
    {
        return table.remove(name);
    }

}
