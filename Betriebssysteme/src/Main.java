
public class Main {
	public static void main(String[] args) {
		stackOverFlow(0);
	}

	private static void aufgabe1() {
		while(true) {}
	}

	private static void stackOverFlow(int i) {
		System.out.println(i);
		stackOverFlow(++i);
	}
}
