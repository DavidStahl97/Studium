package de.thm.Multithreading.deadlock;

public class Philosoph1 extends Thread {

    private String gabel;
    private String messer;

    public Philosoph1(String gabel, String messer)
    {
        this.gabel = gabel;
        this.messer = messer;
    }

    @Override
    public void run() {
        synchronized (gabel) {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {

            }

            synchronized (messer) {

            }
        }
    }
}
