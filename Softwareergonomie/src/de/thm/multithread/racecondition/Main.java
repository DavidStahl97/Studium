package de.thm.multithread.racecondition;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        var konto = new Konto();
        var k1 = new KundeOne(konto);
        var k2 = new KundeTwo(konto);

        k1.start();
        k2.start();

        k1.join();
        k2.join();

        System.out.println(konto);
    }

}
