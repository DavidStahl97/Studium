package de.thm.creationPatterns.Factory;

import de.thm.creationPatterns.Models.Produzent;

public class ProductionFactory {

    public static Produzent createProduzent(String name)
    {
        return new Produzent(name);
    }

}
