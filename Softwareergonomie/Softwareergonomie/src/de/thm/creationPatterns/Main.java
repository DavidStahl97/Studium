package de.thm.creationPatterns;

import de.thm.creationPatterns.Factory.HaendlerFactory;
import de.thm.creationPatterns.Factory.LaedenFactory;
import de.thm.creationPatterns.Factory.ProductionFactory;
import de.thm.creationPatterns.Models.Produzent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException
    {
        var haendler = HaendlerFactory.Create();

        var laden = LaedenFactory.createLaden("Laden1");

        var produzent = GetProduzent();
        var name = Input("Produkt eingeben: ");

        haendler.einkaufenBei(produzent, name);
        haendler.einlagern();

        var product = laden.entnehmen(name);

        System.out.println(product);
    }

    public static String Input(String output) throws IOException
    {
        System.out.println(output);

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String eingabe = br.readLine();
        return eingabe;
    }

    public static Produzent GetProduzent() throws IOException
    {
        var name = Input("Produzent: ");
        return ProductionFactory.createProduzent(name);
    }

}
