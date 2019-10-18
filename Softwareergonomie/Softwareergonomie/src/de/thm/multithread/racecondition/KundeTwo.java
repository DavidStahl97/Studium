package de.thm.multithread.racecondition;

public class KundeTwo extends Thread {

    private Konto konto;

    public KundeTwo(Konto konto)
    {
        this.konto = konto;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        }
        catch (InterruptedException ex) {  }

        var geld = konto.getGeld();
        konto.setGeld(geld - 200);
    }
}
