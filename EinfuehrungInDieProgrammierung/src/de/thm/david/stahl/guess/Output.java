package de.thm.david.stahl.guess;

public enum Output
{
    FAR_TO_SMALL("Viel zu klein!"),
    FAR_TO_LARGE("Viel zu groß"),
    TO_SMALL("Zu klein!"),
    TO_LARGE("Zu groß!"),
    BIT_TO_SMALL("Ein bisschen zu klein!"),
    BIT_TO_LARGE("Ein bisschen zu groß!"),
    FOUND("Richtig!");

    private final String text;

    Output(final String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
