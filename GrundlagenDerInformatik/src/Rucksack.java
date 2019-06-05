import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rucksack {
	
	private List<Packet> packete;
	
	public Rucksack(Rucksack rucksack) {
		this.packete = new ArrayList<Packet>(rucksack.packete);
	}
	
	public Rucksack() {
		packete = new ArrayList<Packet>();
	}
	
	public void add(Packet p) {
		packete.add(p);
	}
	
	public void remove(Packet p) {
		packete.remove(p);
	}
	
	public int getWert() {
		int sum = 0;
		for(Packet p : packete) {
			sum += p.getWert();
		}
		
		return sum;
	}
	
	public int getGewicht() {
		int sum = 0;
		for(Packet p : packete) {
			sum += p.getGewicht();
		}
		
		return sum;
	}
	
	
	public void sort() {
		Collections.sort(packete, new Comparator<Packet>() {
		    @Override
		    public int compare(Packet lhs, Packet rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		        if(lhs.getDurchschnitt() > rhs.getDurchschnitt()) return 1;
		        if(lhs.getDurchschnitt() < rhs.getDurchschnitt()) return -1;
		        
		        return 0;
		    }
		});
	}
	
	@Override
	public String toString() {
		String s = "Wert, Gewicht, Durschnitt\n";
		for(Packet p : packete) {
			s += p.toString() + "\n";
		}
		
		s += "\nWert: " + getWert();
		return s;
	}
	
}
