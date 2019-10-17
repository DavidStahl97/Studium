package de.thm.excercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excercise_1 {

    public static void main(String[] args) throws IOException
    {
        var number = (int)(Math.random() * 1000);
        while(!Try(number));
    }

    private static boolean Try(int value) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Gib was ein: ");
        String eingabe = br.readLine();

        if(eingabe.equals("exit"))
        {
            return true;
        }

        var integer = Integer.parseInt(eingabe);

        boolean correct = value == integer;

        if(correct)
        {
            System.out.println("Richtig");
            return true;
        }

        String s = integer > value ? "größer" : "kleiner";
        System.out.println(s);
        return false;
    }
}
