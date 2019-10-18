package de.thm.multithread.livelock;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        var verhandlung = new Verhandlung();
        var polizei = new Polizei(verhandlung);
        var verbrecher = new Verbrecher(verhandlung);

        polizei.start();
        verbrecher.start();

        polizei.join();
        verbrecher.join();
    }

}
