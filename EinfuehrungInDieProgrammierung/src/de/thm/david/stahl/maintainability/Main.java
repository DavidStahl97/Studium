package de.thm.david.stahl.maintainability;

public class Main
{
    public static void main(String[] args)
    {
        for(int i = 1; i <= 10; i++)
        {
            double pi = Calculator.calculatePi(i);
            System.out.println("i: " + i + " pi: " + pi);
        }
    }
}
