package de.thm.creationPatterns.Factory;

import de.thm.creationPatterns.Models.Bestandslaeger;
import de.thm.creationPatterns.Models.Haendler;

public class HaendlerFactory {

    public static Haendler Create()
    {
        var lager = BestandslagerFactory.getBestandslaeger();
        return new Haendler(lager);
    }

}
