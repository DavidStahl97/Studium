package de.thm.creationPatterns.Models;

import de.thm.creationPatterns.Factory.ProductionFactory;

import java.util.*;

public class Haendler implements Observer {

    private Bestandslaeger laeger;
    private List<Product> products = new ArrayList<>();

    public Haendler(Bestandslaeger lager)
    {
        this.laeger = lager;

        laeger.addObserver(this);
    }

    public void einlagern()
    {
        for(var p : products)
        {
            laeger.storeObject(p);
        }

        products.clear();
    }

    public void einkaufenBei(Produzent production, String name)
    {
        var p = production.kaufen(name);
        products.add(p);
    }

    public void einkaufenBei(Produzent produzent, String name, int count)
    {
        for(int i = 0; i < count; i++)
        {
            einkaufenBei(produzent, name);
        }
    }

    public void update(Observable o, Object arg)
    {
        var schreibwaren = ProductionFactory.createProduzent("Schreibwaren");
        einkaufenBei(schreibwaren, "Stift", 10);

        var zeitschriften = ProductionFactory.createProduzent("Zeitschriften");
        einkaufenBei(zeitschriften, "Zeitung", 10);

        einlagern();

        System.out.println("Neue Produkte im Lager");
    }
}
