package de.thm.machine.framework.test;

import java.util.Arrays;

import de.thm.machine.framework.Util;
import de.thm.machine.framework.machines.TuringAcceptorMachine;
import de.thm.machine.framework.machines.TuringMachine;
import de.thm.machine.framework.tupleElements.Domain;
import de.thm.machine.framework.tupleElements.ReadDirection;
import de.thm.machine.framework.tupleElements.State;
import de.thm.machine.framework.tupleElements.TransitionFunction;
import de.thm.machine.framework.tupleElements.TuringImage;

public class TuringMaschineAlgorithm {
	
	public static void addition() {
		
		var s0 = new State("s0", false);
		var s1 = new State("s1", false);
		var end = new State("end", true);
		
		var function = new TransitionFunction[] {
			new TransitionFunction(new Domain(s0, '1'), new TuringImage(s1, ' ', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(s1, '1'), new TuringImage(s1, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(s1, Util.SPACE), new TuringImage(end, '1', ReadDirection.NEUTRAL))
		};
		
		var maschine = new TuringMachine(Arrays.asList(function), s0);
		var input = "1111 11";
		
		System.out.println("Eingabe: " + input);
		var result = maschine.start(input);
		System.out.println(result);
	}
	
	public static void division() {
		// Dividieren von zwei natürlichen Zahlen
		// Der Rest wird nicht angegeben.
		// Der Quotient kann auch 0 sein
		// Dividend : Divisor = Wert des Quotienten
		
		var lm0 = new State("lm0");
		var lm1 = new State("lm1");
		var lm2 = new State("lm2");
		
		var rm0 = new State("rm0");
		var rm1 = new State("rm1");
		var rm2 = new State("rm2");
		
		var sub0 = new State("sub0");
		var sub1 = new State("sub1");
		var sub2 = new State("sub2");
		var sub3 = new State("sub3");
		var sub4 = new State("sub4");
		var sub5 = new State("sub5");
		var sub6 = new State("sub6");
		var sub7 = new State("sub7");
		var sub8 = new State("sub8");
		var sub9 = new State("sub9");
		var sub10 = new State("sub10");
		var sub11 = new State("sub11");
		var sub12 = new State("sub12");
		
		var erg0 = new State("erg0");
		var erg1 = new State("erg1");
		var erg2 = new State("erg2");
		var erg3 = new State("erg3");
		var erg4 = new State("erg4");
		var erg5 = new State("erg5");
		var erg6 = new State("erg6");
		var erg7 = new State("erg7");
		var erg8 = new State("erg8");
		
		var end = new State("end");
		
		
		var function = new TransitionFunction[] {
			
			// Linker Marker setzen
			new TransitionFunction(new Domain(lm0, '1'), new TuringImage(lm1, '1', ReadDirection.LEFT)),
			
			new TransitionFunction(new Domain(lm1, Util.SPACE), new TuringImage(lm2, Util.SPACE, ReadDirection.LEFT)),
			
			new TransitionFunction(new Domain(lm2, Util.SPACE), new TuringImage(rm0, '1', ReadDirection.RIGHT)),
			
			// Rechter Marker setzen
			new TransitionFunction(new Domain(rm0, Util.SPACE), new TuringImage(rm1, Util.SPACE, ReadDirection.RIGHT)),
			
			new TransitionFunction(new Domain(rm1, '1'), new TuringImage(rm1, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(rm1, Util.SPACE), new TuringImage(rm2, Util.SPACE, ReadDirection.RIGHT)),
			
			new TransitionFunction(new Domain(rm2, '1'), new TuringImage(rm2, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(rm2, Util.SPACE), new TuringImage(sub0, '1', ReadDirection.LEFT)),
			
			// Den Dividenden mit dem Divisor subtrahieren und den Quotienten inkrementieren
			// Löschen einer Eins des Divisors
			new TransitionFunction(new Domain(sub0, '1'), new TuringImage(sub1, Util.SPACE, ReadDirection.LEFT)),
			
			// Zum Dividenden springen
			new TransitionFunction(new Domain(sub1, '1'), new TuringImage(sub1, '1', ReadDirection.LEFT)),
			new TransitionFunction(new Domain(sub1, Util.SPACE), new TuringImage(sub2, Util.SPACE, ReadDirection.LEFT)),
			
			// Falls der Dividend komplett gelöscht wurde, ist das Ergebnis des Quotienten fest
			new TransitionFunction(new Domain(sub2, Util.SPACE), new TuringImage(erg0, '1', ReadDirection.LEFT)),
			new TransitionFunction(new Domain(sub2, '1'), new TuringImage(sub3, '1', ReadDirection.LEFT)),
			
			new TransitionFunction(new Domain(sub3, '1'), new TuringImage(sub3, '1', ReadDirection.LEFT)),
			new TransitionFunction(new Domain(sub3, Util.SPACE), new TuringImage(sub4, Util.SPACE, ReadDirection.RIGHT)),
			
			// Löschen einer Eins des Dividenden
			new TransitionFunction(new Domain(sub4, '1'), new TuringImage(sub5, Util.SPACE, ReadDirection.RIGHT)),
			
			// Zum Divisor springen
			new TransitionFunction(new Domain(sub5, '1'), new TuringImage(sub5, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(sub5, Util.SPACE), new TuringImage(sub6, Util.SPACE, ReadDirection.RIGHT)),
			
			// Falls der Divisor keine Einsen mehr hat, wird er wieder aufgefüllt 
			new TransitionFunction(new Domain(sub6, '1'), new TuringImage(sub7, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(sub6, Util.SPACE), new TuringImage(sub8, '1', ReadDirection.RIGHT)),
			
			// Holen der nächste Eins des Divisors 
			new TransitionFunction(new Domain(sub7, '1'), new TuringImage(sub7, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(sub7, Util.SPACE), new TuringImage(sub0, Util.SPACE, ReadDirection.LEFT)),
					
			// Auffüllen des Divisors
			new TransitionFunction(new Domain(sub8, Util.SPACE), new TuringImage(sub8, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(sub8, '1'), new TuringImage(sub9, '1', ReadDirection.RIGHT)),
			
			// Inkrementieren des Quotienten
			new TransitionFunction(new Domain(sub9, Util.SPACE), new TuringImage(sub10, Util.SPACE, ReadDirection.RIGHT)),
			
			new TransitionFunction(new Domain(sub10, '1'), new TuringImage(sub10, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(sub10, Util.SPACE), new TuringImage(sub11, '1', ReadDirection.LEFT)),
			
			// Zum Divisor wechseln
			new TransitionFunction(new Domain(sub11, '1'), new TuringImage(sub11, '1', ReadDirection.LEFT)),
			new TransitionFunction(new Domain(sub11, Util.SPACE), new TuringImage(sub12, Util.SPACE, ReadDirection.LEFT)),
			
			new TransitionFunction(new Domain(sub12, '1'), new TuringImage(sub0, '1', ReadDirection.LEFT)),
			
			
			// Ergebnis verschönern
			// Den linken Marker finden und löschen
			new TransitionFunction(new Domain(erg0, Util.SPACE), new TuringImage(erg0, Util.SPACE, ReadDirection.LEFT)),
			new TransitionFunction(new Domain(erg0, '1'), new TuringImage(erg1, Util.SPACE, ReadDirection.RIGHT)),
			
			new TransitionFunction(new Domain(erg1, Util.SPACE), new TuringImage(erg2, Util.SPACE, ReadDirection.RIGHT)),
			
			// Den Dividenden wiederherstellen
			new TransitionFunction(new Domain(erg2, Util.SPACE), new TuringImage(erg2, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(erg2, '1'), new TuringImage(erg3, '1', ReadDirection.RIGHT)),
			
			// Zum Divisor springen
			new TransitionFunction(new Domain(erg3, Util.SPACE), new TuringImage(erg4, Util.SPACE, ReadDirection.RIGHT)),
			
			// Den Divisor wiederherstellen
			new TransitionFunction(new Domain(erg4, '1'), new TuringImage(erg4, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(erg4, Util.SPACE), new TuringImage(erg5, '1', ReadDirection.RIGHT)),
			
			new TransitionFunction(new Domain(erg5, Util.SPACE), new TuringImage(erg5, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(erg5, '1'), new TuringImage(erg6, Util.SPACE, ReadDirection.RIGHT)),
			
			// Den Quotienten um 1 nach links verschieben und der Algorithmus terminiert
			new TransitionFunction(new Domain(erg6, Util.SPACE), new TuringImage(erg7, '1', ReadDirection.RIGHT)),
			
			new TransitionFunction(new Domain(erg7, '1'), new TuringImage(erg7, '1', ReadDirection.RIGHT)),
			new TransitionFunction(new Domain(erg7, Util.SPACE), new TuringImage(erg8, Util.SPACE, ReadDirection.LEFT)),
			
			new TransitionFunction(new Domain(erg8, '1'), new TuringImage(end, Util.SPACE, ReadDirection.RIGHT))
		};
		
		
		var maschine = new TuringMachine(Arrays.asList(function), lm0);
		var input = "111111111111111111111111111111 111";
		
		System.out.println("Eingabe: " + input);
		var result = maschine.start(input);
		System.out.println(result);
	}
	
}
