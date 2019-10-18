package de.thm.creationPatterns;

import de.thm.creationPatterns.Factory.HaendlerFactory;
import de.thm.creationPatterns.Factory.LaedenFactory;
import de.thm.creationPatterns.Factory.ProductionFactory;
import de.thm.creationPatterns.Models.Produzent;

import java.io.IOException;

public class Facede {

    public void kaufen(int x, int y) throws IOException
    {
        var haendler = HaendlerFactory.Create();

        var schreibwaren = ProductionFactory.createProduzent("Schreibwaren");
        haendler.einkaufenBei(schreibwaren, "Stift", x);

        var zeitschriften = ProductionFactory.createProduzent("Zeitschriften");
        haendler.einkaufenBei(zeitschriften, "Zeitung", y);

        haendler.einlagern();
    }



}
