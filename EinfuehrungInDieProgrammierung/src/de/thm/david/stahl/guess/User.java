package de.thm.david.stahl.guess;

import java.util.Scanner;

public class User
{
    private Scanner scanner;

    public User(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public int guess()
    {
        return scanner.nextInt();
    }

    public int getSmallestNumber()
    {
        int a;
        do
        {
            a = scanner.nextInt();
            if(a < 0)
            {
                a = -1;
            }
        }
        while (a == -1);

        return a;
    }

    public int getLargestNumber(int a)
    {
        int b;
        do
        {
            b = scanner.nextInt();
            if(b < a)
            {
                b = -1;
            }
        }
        while(b == -1);

        return b;
    }
}
