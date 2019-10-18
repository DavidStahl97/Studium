package de.thm.multithread.livelock;

public class Polizei extends Thread {

    private Verhandlung verhandlung;

    public Polizei(Verhandlung v)
    {
        verhandlung = v;
    }

    @Override
    public void run() {
        while(true)
        {
            if(verhandlung.hasAccepted())
            {
                break;
            }

            var geld = (int)(Math.random() * 100);
            verhandlung.setGeld(geld);

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) { break; }
        }
    }
}
