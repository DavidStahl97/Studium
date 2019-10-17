package de.thm.multithread.racecondition;

public class Konto {

    private int geld = 200;

    public int getGeld()
    {
        return geld;
    }

    public void setGeld(int geld)
    {
        this.geld = geld;
    }

    @Override
    public String toString() {
        return "Geld: " + geld;
    }
}
