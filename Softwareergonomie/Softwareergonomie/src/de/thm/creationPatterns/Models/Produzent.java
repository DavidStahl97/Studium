package de.thm.creationPatterns.Models;

public class Produzent {

    private String name;

    public Produzent(String name)
    {
        this.name = name;
    }

    public Product kaufen(String name)
    {
        return new Product(name, this);
    }

    @Override
    public String toString() {
        return "Produzent: " + name;
    }
}
