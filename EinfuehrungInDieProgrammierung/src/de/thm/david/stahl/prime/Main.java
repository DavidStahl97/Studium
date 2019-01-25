package de.thm.david.stahl.prime;

import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int number;
        do
        {
            number = getNumber();
            showAllPrimes(number);
        }
        while(number > 1);
    }

    private static int getNumber()
    {
        System.out.println();
        System.out.print("Bitte die Zahl eingeben: ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static void showAllPrimes(int number)
    {
        List<Integer> primes = Calculator.primeFactorization(number);

        System.out.print(number + " = ");
        for(int prime : primes)
        {
            System.out.print(prime + " * ");
        }
    }
}
