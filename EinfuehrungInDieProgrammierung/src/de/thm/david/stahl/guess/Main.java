package de.thm.david.stahl.guess;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static User user = new User(scanner);
    private static RandomNumberGame game;

    public static void main(String[] args)
    {
        defineGame();
        play();
    }

    private static void defineGame()
    {
        System.out.println("Geben sie den Bereich an (zwischen a und b):");

        System.out.print("a: ");
        int a = user.getSmallestNumber();

        System.out.println("b: ");
        int b = user.getLargestNumber(a);

        game = new RandomNumberGame(a, b);
        game.generateRandomNumber();
    }

    private static void play()
    {
        Output output;
        do
        {
            System.out.println();
            System.out.println("Rate:");

            int guess = user.guess();
            output = game.guess(guess);
            System.out.println(output);
        }
        while(output != output.FOUND);
    }
}
