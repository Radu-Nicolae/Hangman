package hangman.gameModes;

import hangman.utilities.DataBase;
import hangman.utilities.GameUtilities;
import hangman.utilities.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayWithCpu {

    static Scanner scn = new Scanner(System.in);
    static Random rnd = new Random();

    public static void playWithCpu() {
        boolean isInputInvalid;
        boolean isGameNotOver;
        boolean playAgain;
        boolean firstTime = true;
        int intInput;
        String letter;
        String word = null;
        String input;
        List<String> hangManImages = Messages.hangManImages();
        List<Character> wordLetters = new ArrayList<>();
        List<Character> blindWordLetters = new ArrayList<>();
        List<Character> enteredLetters = new ArrayList<>();
        List<String> words = DataBase.getWords();

        do {
            int i = 1;
            do {
                if (i == 1) {
                    intInput = rnd.nextInt(words.size()) + 1;
                    word = words.get(intInput);
                    wordLetters = GameUtilities.getSplitTheWord(word);
                    blindWordLetters = GameUtilities.getBlindWord(word);
                    i++;
                }
                isInputInvalid = true;


                if (firstTime) {
                    System.out.println(Messages.hangManImages().get(0));
                    GameUtilities.printBlindWord(blindWordLetters);
                    System.out.print("\nEnter a letter: ");
                    firstTime = false;
                } else {
                    System.out.print("\nEnter a letter: ");
                }
                do {

                    letter = scn.next();
                    if (enteredLetters.contains(letter.charAt(0))) {
                        System.out.println("You've already entered letter '" + letter.charAt(0) + "'");
                        System.out.print("Enter another letter: ");
                    } else {
                        if (letter.length() == 1 && ((letter.charAt(0) >= 48 && letter.charAt(0) <= 57) || (letter.charAt(0) >= 97 && letter.charAt(0) <= 122))) {
                            isInputInvalid = false;
                        } else if (letter.length() != 1) {
                            System.out.print("Please enter only one character: ");
                        } else {
                            System.out.print("Please enter a letter/number: ");
                        }
                    }
                }
                while (isInputInvalid);

                letter = letter.toLowerCase();
                char lett;

                lett = letter.charAt(0);
                enteredLetters.add(lett);

                for (int k = 0; k < wordLetters.size(); k++) {
                    if (wordLetters.get(k) == lett) {
                        blindWordLetters.remove(k);
                        blindWordLetters.add(k, lett);
                        enteredLetters.add(lett);
                    }
                }


                if (!wordLetters.contains(lett)) {
                    i++;
                    System.out.println(hangManImages.get(i - 2));
                }
                GameUtilities.printBlindWord(blindWordLetters);


                if (i == 8) {
                    System.out.println("\nYou've lost! :(");
                    System.out.println("The word was " + word);
                    isGameNotOver = false;
                } else {
                    isGameNotOver = true;
                }

                for (int j = 0; j < blindWordLetters.size(); j++) {
                    if (!blindWordLetters.contains('_')) {
                        Messages.youWon();
                        isGameNotOver = false;
                        break;
                    }
                }
            } while (isGameNotOver);

            System.out.println("\nPlay again?");
            System.out.print("Your answer: ");
            isInputInvalid = true;

            do {
                input = scn.next();
                if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                    isInputInvalid = false;
                } else {
                    System.out.print("Please enter a valid input (yes/no): ");
                }
            }
            while (isInputInvalid);

            playAgain = input.equalsIgnoreCase("yes");

            if (input.equalsIgnoreCase("yes")) {
                blindWordLetters.clear();
                wordLetters.clear();
                enteredLetters.clear();
                firstTime = true;
            }
        } while (playAgain);

        Messages.goodBye();
    }
}
