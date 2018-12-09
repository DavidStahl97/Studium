package de.thm.david.stahl.operation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		try
		{
			System.out.println("Eingabe");
			
			System.out.print("Operant Eins: ");
			int a = in.nextInt();
			
			System.out.print("Operant Zwei: ");
			int b = in.nextInt();
			
			
			System.out.println();
			
			System.out.println("Ergebnis");
			calculate(a, b);
		}
		catch (InputMismatchException ex)
		{
			System.out.println("Falsche Eingabe!");
		}
		finally
		{
			in.close();
		}
	}
	
	private static void calculate(int a, int b)
	{
		System.out.println("Add: " + Comparator.add(a, b));
		System.out.println("Substract: " + Comparator.substract(a, b));
	}
}
