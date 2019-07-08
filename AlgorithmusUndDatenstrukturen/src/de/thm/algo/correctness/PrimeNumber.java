package de.thm.algo.correctness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
	
	private static int performance1 = 0;
	private static int performance2 = 0;
	
	public static void main(String[] args) {
		System.out.println("Wort eingeben: ");
		var buffer = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			performance1 = 0;
			performance2 = 0;
			
			try {
				var s = buffer.readLine();
				if(s.equals("exit")) return;
				
				int number = Integer.parseInt(s);
				
				boolean result = isPrime(number);				
				System.out.println(result + " Performance: " + performance1);
				
				result = isPrime2(number);				
				System.out.println(result + " Performance: " + performance2);
			} catch (IOException e) {
				System.out.println("Invalide Eingabe!");
			}
		}
	}
	
	private static boolean isPrime(int number) {
		for(int i = 2; i <= number / 2; i++) {
			performance1++;
			if(number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isPrime2(int number) {		
		var primeNumbers = new ArrayList<Integer>();
		
		for(int i = 2; i < number; i++) {
			addIntoPrimeNumbers(primeNumbers, i);
		}
		
		System.out.print("[");
		for(var prime : primeNumbers) {
			System.out.print(prime + ",");
		}
		System.out.println("]");
		
		return addIntoPrimeNumbers(primeNumbers, number);
	}
	
	private static boolean addIntoPrimeNumbers(List<Integer> primeNumbers, int number) {
		for(var prime : primeNumbers) {
			performance2++;
			if(number % prime == 0) {
				return false;
			}
		}
		
		primeNumbers.add(number);
		return true;
	}
	
}
