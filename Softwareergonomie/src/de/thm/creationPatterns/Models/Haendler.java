package de.thm.creationPatterns.Models;

import java.util.ArrayList;
import java.util.List;

public class Haendler {

    private Bestandslaeger laeger;
    private List<Product> products = new ArrayList<>();

    public Haendler(Bestandslaeger lager)
    {
        this.laeger = lager;
    }

    public void einlagern()
    {
        for(var p : products)
        {
            laeger.storeObject(p);
        }

        products.clear();
    }

    public void einkaufenBei(Produzent production, String id)
    {
        var p = production.kaufen(id);
        products.add(p);
    }

}
