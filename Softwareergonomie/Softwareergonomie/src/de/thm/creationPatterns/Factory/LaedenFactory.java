package de.thm.creationPatterns.Factory;

import de.thm.creationPatterns.Models.Laden;

public class LaedenFactory {

    public static Laden createLaden(String name)
    {
        var lager = BestandslagerFactory.getBestandslaeger();
        return new Laden(name, lager);
    }

}
