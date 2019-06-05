import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static Rucksack besterRucksack;
	private static List<Packet> packete;
	
	public static void main(String[] args) {
		Packet[] array = {
			new Packet(4, 12),
			new Packet(2, 2),
			new Packet(1, 1),
			new Packet(10, 4),
			new Packet(2, 1)
		};
		
		packete = new ArrayList<Packet>(Arrays.asList(array));
		
		unboundedKnapsack(new Rucksack(), 15);
		
		System.out.println("Die beste Möglichkeit: ");
		System.out.println(besterRucksack);
		
	}
	
	private static void unboundedKnapsack(Rucksack rucksack, int max) {		
		for(Packet p : packete) {			
			if(p.getGewicht() + rucksack.getGewicht() <= max) {
				rucksack.add(p);
				unboundedKnapsack(rucksack, max);
				rucksack.remove(p);
			}
			else {
				if(besterRucksack == null || rucksack.getWert() > besterRucksack.getWert()) {
					besterRucksack = new Rucksack(rucksack);
				}
			}			
		}
	}
	
}
