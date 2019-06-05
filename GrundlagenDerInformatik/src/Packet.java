
public class Packet {
	
	private int wert;
	private int gewicht;
	
	public Packet(int wert, int gewicht) {
		this.wert = wert;
		this.gewicht = gewicht;
	}
	
	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	public double getDurchschnitt() {
		return wert / gewicht;
	}
	
	@Override
	public String toString() {
		return wert + ", " + gewicht + ", " + getDurchschnitt();
	}
}
