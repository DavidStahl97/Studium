package de.thm.david.stahl.maintainability;

public class BadCode
{
    static double funktion(int no_of_digits
    ) {int a = (int)Math.pow(10., no_of_digits) / 2; double b = 0;
        int Vorzeichen = 1; int denominator = 1;
        int i = 0;
        while (true)
        {
            b += Vorzeichen * 4. / denominator++;
            if (Vorzeichen == 1) {
                Vorzeichen = -1;
            } else {
                Vorzeichen = 1;}
            if (++i == a) break;
            denominator++;
        }
        return b;
    } public static void main(String[] args) {
    System.out.println(funktion(1));			System.out.println(funktion(2));
    System.out.println(funktion(3));System.out.println(funktion(4));			System.out.println(funktion(5));
    System.out.println(funktion(6));
    System.out.println(funktion(7));
    System.out.println(funktion(8));
}
}
