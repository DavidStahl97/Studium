package de.thm.creationPatterns.Models;

import java.util.UUID;

public class Product {

    private String name;
    private String id;
    private Produzent produzent;

    public Product(String name, Produzent produzent)
    {
        this.name = name;
        this.produzent = produzent;

        id = UUID.randomUUID().toString();
    }

    public String getId()
    {
        return id;
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
