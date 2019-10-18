package de.thm.creationPatterns.Factory;

import de.thm.creationPatterns.Models.Bestandslaeger;

public class BestandslagerFactory {

    private static Bestandslaeger lager = new Bestandslaeger();

    public static Bestandslaeger getBestandslaeger()
    {
        return lager;
    }

}
