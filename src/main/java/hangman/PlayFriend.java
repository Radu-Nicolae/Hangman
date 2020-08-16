package hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayFriend {

    static Scanner scn = new Scanner(System.in);

    public static void playWithFriend() {
        boolean isInputInvalid = true;
        boolean player1Starts;
        boolean isGameNotOver;
        boolean playAgain;
        boolean firstTime = true;
        String letter;
        String word = null;
        String input;

        System.out.print("Enter player's 1 name: ");
        String player1Name = scn.nextLine();

        System.out.print("Enter player's 2 name: ");
        String player2Name = scn.nextLine();


        List<String> hangManImages = Messages.hangManImages();
        List<Character> wordLetters = new ArrayList<>();
        List<Character> blindWordLetters = new ArrayList<>();
        List<Character> enteredLetters = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        do {
            int i = 1;
            do {
                if (i == 1) {
                    System.out.println("\nWho will guess first?");
                    System.out.print("Your answer: ");

                    do {
                        input = scn.next();
                        if (input.equalsIgnoreCase(player1Name) || input.equalsIgnoreCase(player2Name)) {
                            isInputInvalid = false;
                        } else {
                            System.out.print("Please enter a valid input: ");
                        }
                    }
                    while (isInputInvalid);
                    player1Starts = !input.equalsIgnoreCase(player1Name);

                    if (player1Starts) {
                        System.out.println("\n" + player1Name + " please enter a word!");
                        System.out.print("!Note: don't let " + player2Name + " see your word: ");
                    } else {
                        System.out.println("\n" + player2Name + " please enter a word!");
                        System.out.print("!Note: don't let " + player1Name + " see your word: ");
                    }
                    System.out.println("\n");
                    System.out.print("The word: ");
                    word = scn.next();
                    word = word.toLowerCase();
                    wordLetters = GameUtilities.getSplitTheWord(word);
                    blindWordLetters = GameUtilities.getBlindWord(word);
                    Messages.someTextArt1();
                    System.out.println(Messages.hangManImages().get(Messages.hangManImages().size() - 1));
                    Messages.someTextArt2();
                    i++;
                }
                isInputInvalid = true;


                if (firstTime) {
                    System.out.println(Messages.hangManImages().get(0));
                    GameUtilities.printBlindWord(blindWordLetters);
                    System.out.print("\nEnter a letter: ");
                    firstTime = false;
                }
                else {
                    System.out.print("\nEnter a letter: ");
                }
                do {

                    letter = scn.next();
                    if (enteredLetters.contains(letter.charAt(0))){
                        System.out.println("You've already entered letter '" + letter.charAt(0) + "'");
                        System.out.print("Enter another letter: ");
                    } else {
                        if (letter.length() == 1) {
                            isInputInvalid = false;
                        } else {
                            System.out.print("Please enter only a letter: ");
                        }
                    }
                }
                while (isInputInvalid);

                letter = letter.toLowerCase();
                char lett = letter.charAt(0);

                for (int j = 0; j < word.length(); j++) {
                    if (lett == wordLetters.get(j)) {
                        indexes.add(j);
                    }
                }

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
                    GameUtilities.printBlindWord(blindWordLetters);
                }
                else {
                    GameUtilities.printBlindWord(blindWordLetters);
                }



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
                if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")){
                    isInputInvalid = false;
                }
                else {
                    System.out.print("Please enter a valid input: ");
                }
            }
            while (isInputInvalid);

            playAgain = input.equalsIgnoreCase("yes");

            if (input.equalsIgnoreCase("yes")){
                indexes.clear();
                blindWordLetters.clear();
                wordLetters.clear();
                enteredLetters.clear();
            }
        } while (playAgain);

        Messages.goodBye();
    }

}
