package hangman;

import hangman.gameModes.PlayFriend;
import hangman.gameModes.PlayWithCpu;
import hangman.utilities.Messages;

import java.util.Scanner;

public class Game {

    static Scanner scn = new Scanner(System.in);

    public static void hangman() {
        Messages.welcome();
        boolean isInputInvalid = true;
        String input;

        System.out.println("Who do you want to play against?");
        System.out.println("1. Your friend");
        System.out.println("2. CPU");
        System.out.print("\nYour answer: ");

        do {
            input = scn.next();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")) {
                isInputInvalid = false;
            } else {
                System.out.print("Please choose between 1 and 2: ");
            }
        }
        while (isInputInvalid);

        if (input.equalsIgnoreCase("1")) {
            System.out.println("You have chosen to play against your friend!");
            PlayFriend.playWithFriend();
        } else {
            System.out.println("You have chosen to play against CPU!");
            PlayWithCpu.playWithCpu();
        }
    }
}
