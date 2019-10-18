package de.thm.multithread.livelock;

public class Verhandlung {

    private int geld = 0;
    private boolean accepted = false;

    public synchronized void setGeld(int geld)
    {
        this.geld = geld;
    }

    public synchronized int getGeld()
    {
        return geld;
    }

    public synchronized boolean hasAccepted()
    {
        return accepted;
    }

    public synchronized void setAccepted(boolean a)
    {
        accepted = a;
    }
}
