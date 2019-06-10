package de.thm.language;

public class Main {
	
	public static void main(String[] args) {
		
		testKellerautomat();
		
	}
	
	private static void testDeterministicAutomat() {
		String s = "aaaabbbabb";
		
		DeterministicAutomat automat = new DeterministicAutomat();
		boolean result = automat.isInLanguage(s);
		
		System.out.println("Wort: " + s);
		System.out.println("Deterministischer endlicher Automat: " + result);
	}
	
	private static void testKellerautomat() {
		String s = "(3*4+2)*9";
		
		Kellerautomat automat = new Kellerautomat();
		boolean result = automat.isInLanguage(s);
		
		System.out.println("Wort: " + s);
		System.out.println("Deterministischer endlicher Automat: " + result);
	}
	
}
