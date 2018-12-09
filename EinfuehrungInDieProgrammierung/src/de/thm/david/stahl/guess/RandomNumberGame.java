package de.thm.david.stahl.guess;

public class RandomNumberGame
{
    private int smallestNumber;
    private int largestNumber;

    private int a;
    private int b;
    private int number;

    public RandomNumberGame(int smallestNumber, int largestNumber)
    {
        this.smallestNumber = smallestNumber;
        this.largestNumber = largestNumber;
    }

    public void generateRandomNumber()
    {
        // smallesNumber < a < largestNumber
        a = (int)(Math.random() * (largestNumber - smallestNumber - 1) + (smallestNumber + 1));

        // a <= b < largestNumber
        b = (int)(Math.random() * (largestNumber - a) + a);

        number = ((b - a) / 2) + a;
    }

    public Output guess(int guessingNumber)
    {
        if(guessingNumber < a)
        {
            return Output.FAR_TO_SMALL;
        }
        else if(guessingNumber > b)
        {
            return Output.FAR_TO_LARGE;
        }
        else if(guessingNumber < (number - a) / 2 + a)
        {
            return Output.TO_SMALL;
        }
        else if(guessingNumber > (b - number) / 2 + number)
        {
            return Output.TO_LARGE;
        }
        else if(guessingNumber < number)
        {
            return Output.BIT_TO_SMALL;
        }
        else if(guessingNumber > number)
        {
            return Output.BIT_TO_LARGE;
        }
        else
        {
            return Output.FOUND;
        }
    }
}
