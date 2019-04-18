package de.thm.david.stahl.maintainability;

public class Calculator
{
    public static double calculatePi(int accuracyExponent)
    {
        double pi = 0.0;
        int sign = 1;
        int accuracy = (int)Math.pow(10, accuracyExponent) / 2;

        for(int i = 1; i <= accuracy; i++)
        {
            int denominator = 2 * i - 1;
            pi += (sign * 4.0) / denominator;
            sign *= -1;
        }

        return pi;
    }
}
