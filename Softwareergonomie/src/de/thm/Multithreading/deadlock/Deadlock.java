package de.thm.Multithreading.deadlock;

public class Deadlock {

    public static void main(String[] args) throws InterruptedException
    {
        String messer = "messer";
        String gabel = "gabel";

        var p1 = new Philosoph1(messer, gabel);
        var p2 = new Philosoph2(messer, gabel);

        p1.run();
        p2.run();

        p1.join();
        p2.join();
    }

}
