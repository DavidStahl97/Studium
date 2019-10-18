package de.thm.adapterPattern.Adapter;

import de.thm.adapterPattern.German.DEStecker;
import de.thm.adapterPattern.German.IDEStecker;

public class UKAdapter implements IUKAdapter {

    private IDEStecker deStacker;

    public void provideElectricity()
    {

    }

    public void setDeStacker(IDEStecker deStacker)
    {
        this.deStacker = deStacker;
    }

}
