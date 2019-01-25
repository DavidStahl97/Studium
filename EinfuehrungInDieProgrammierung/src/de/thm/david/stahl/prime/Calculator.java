package de.thm.david.stahl.prime;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    public static List<Integer> primeFactorization(int number)
    {
        List<Integer> primes = new ArrayList();

        for(int i = 2; i <= number; i++)
        {
            while(number % i == 0)
            {
                primes.add(i);
                number /= i;
            }
        }

        return primes;
    }
}
