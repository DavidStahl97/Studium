package de.thm.david.stahl.decimal;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Decimal[] list = readDecimals();

            if(list.length > 0)
            {
                writeDecimals(list);
                showSmallestNumber(list);
            }
        }
        catch(Exception ex)
        {
            throw ex;
            //System.out.println("Probleme mit der Formatierung");
        }
    }



    private static Decimal[] readDecimals()
    {
        Scanner s = new Scanner(System.in);

        System.out.print("Anzahl der Zahlen: ");
        int count = s.nextInt();

        Decimal[] list = new Decimal[count];
        for(int i = 0; i < count; i++)
        {
            System.out.println("Zahl: ");
            list[i] = new Decimal(s.nextDouble());
        }

        return list;
    }

    private static void writeDecimals(Decimal[] decimals)
    {
        System.out.println("Kontrollausgabe:");

        for(Decimal d : decimals)
        {
            System.out.println(d.getNumber());
        }
    }

    private static void showSmallestNumber(Decimal[] decimals)
    {
        Decimal d = decimals[0];

        for(int i = 1; i < decimals.length; i++)
        {
            if(d.getNumber() > decimals[i].getNumber())
            {
                d = decimals[i];
            }
        }

        System.out.println("Minimum: " + d.getNumber());
    }
}
