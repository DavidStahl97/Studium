package de.thm.david.stahl.decimal;

public class Decimal
{
    private static final int MAX_NUMBER_OF_CHARACTERS = 3;

    private int integer;
    private int afterComma;

    public Decimal(double number)
    {
        split(number);
    }

    private void split(double number)
    {
        String[] s = Double.toString(number).split("\\.");
        integer = Integer.parseInt(s[0]);

        setAfterComma(s[1]);
    }

    private void setAfterComma(String s)
    {
        boolean increment = false;

        if(s.length() > MAX_NUMBER_OF_CHARACTERS)
        {
            int fourthCharacter = Character.getNumericValue(s.charAt(MAX_NUMBER_OF_CHARACTERS));
            s = s.substring(0, MAX_NUMBER_OF_CHARACTERS);

            if(fourthCharacter > 4)
            {
                increment = true;
            }
        }
        else
        {
            while(s.length() < MAX_NUMBER_OF_CHARACTERS)
            {
                s += "0";
            }
        }

        afterComma = Integer.parseInt(s);
        if(increment)
        {
            afterComma++;
        }
    }

    private String getAfterComma()
    {
        String afterCommaString = Integer.toString(afterComma);
        while (afterCommaString.length() < MAX_NUMBER_OF_CHARACTERS)
        {
            afterCommaString = "0" + afterCommaString;
        }

        return afterCommaString;
    }

    public double getNumber()
    {
         return Double.parseDouble(integer + "." + getAfterComma());
    }
}
