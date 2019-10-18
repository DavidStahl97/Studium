package de.thm.creationPatterns;

import de.thm.creationPatterns.Factory.HaendlerFactory;
import de.thm.creationPatterns.Factory.LaedenFactory;

import java.io.IOException;

public class ObserverMain {

    public static void main(String[] args) throws InterruptedException
    {
        var haendler = HaendlerFactory.Create();
        var laden = LaedenFactory.createLaden("Laden1");

        while(true)
        {
            var p = laden.angebot();
            p = laden.entnehmen(p.getId());
            System.out.println(p);
            Thread.sleep(1000);
        }
    }

}
