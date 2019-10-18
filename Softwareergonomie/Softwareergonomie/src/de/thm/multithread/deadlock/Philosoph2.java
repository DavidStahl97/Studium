package de.thm.multithread.deadlock;

public class Philosoph2 extends Thread {

    private String gabel;
    private String messer;

    public Philosoph2(String gabel, String messer)
    {
        this.gabel = gabel;
        this.messer = messer;
    }

    @Override
    public void run() {
        synchronized (messer) {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {

            }

            synchronized (gabel) {

            }
        }
    }
}
