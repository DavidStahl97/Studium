package de.thm.creationPatterns.Models;

public class Laden {

    private String name;
    private Bestandslaeger lager;

    public Laden(String name, Bestandslaeger lager)
    {
        this.name = name;
        this.lager = lager;
    }

    public Product entnehmen(String name)
    {
        return lager.getProduct(name);
    }

    public Product angebot()
    {
        var products = lager.getProducts();
        return products.get(0);
    }
}
