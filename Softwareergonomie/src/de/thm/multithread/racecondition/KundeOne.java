package de.thm.multithread.racecondition;

public class KundeOne extends Thread {

    private Konto konto;

    public KundeOne(Konto konto)
    {
        this.konto = konto;
    }

    @Override
    public void run() {
        var geld = konto.getGeld();

        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException ex) {  }

        konto.setGeld(geld + 200);
    }
}
