package de.thm.creationPatterns.Models;

public class Product {

    private String name;
    private Produzent produzent;

    public Product(String name, Produzent produzent)
    {
        this.name = name;
        this.produzent = produzent;
    }

    public String getId()
    {
        return name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Product: " + name + "\n" + produzent;
    }
}
