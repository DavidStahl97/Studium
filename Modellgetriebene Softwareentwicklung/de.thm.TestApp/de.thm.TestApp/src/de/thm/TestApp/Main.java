package de.thm.TestApp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Class c = Main.class;
		Main main = new Main();
		Method m = null;
		for (Method _m : c.getMethods()) {
			if (_m.getName().equals("doit")) {
				m = _m;
				break;
			}
		}
		long a = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			try {
				m.invoke(main, null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis() - a);

		a = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			main.doit();
		}
		System.out.println(System.currentTimeMillis() - a);
	}

	public void doit() {

	}

}
