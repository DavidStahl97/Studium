package de.thm.multithread.livelock;

public class Verbrecher extends Thread {

    private Verhandlung verhandlung;

    public Verbrecher(Verhandlung v)
    {
        verhandlung = v;
    }

    @Override
    public void run() {
        while(true)
        {
            if(verhandlung.getGeld() > 10000){
                verhandlung.setAccepted(true);
                break;
            }

            verhandlung.setAccepted(false);

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) { break; }
        }
    }
}
