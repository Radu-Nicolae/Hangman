package hangman;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    public static void welcome() {
        System.out.println("================================");
        System.out.println("|  Hello! Welcome to Hangman!  |");
        System.out.println("================================");
        System.out.println("\n");
    }


    public static void someTextArt1() {
        System.out.println("===============================================");
        System.out.println("=======================================");
        System.out.println("===============================");
        System.out.println("=======================");
        System.out.println("===============");
        System.out.println("=======");
        System.out.println("==");
        System.out.println("==");
        System.out.println("==");
        System.out.println("== These lines are used so the");
        System.out.println("== opponent does not see the word");
        System.out.println("==");
        System.out.println("==");
        System.out.println("==");
    }

    public static void someTextArt2() {
        System.out.println("==");
        System.out.println("==");
        System.out.println("==");
        System.out.println("== These lines are used so the");
        System.out.println("== opponent does not see the word");
        System.out.println("==");
        System.out.println("==");
        System.out.println("==");
        System.out.println("=======");
        System.out.println("===============");
        System.out.println("=======================");
        System.out.println("===============================");
        System.out.println("=======================================");
        System.out.println("===============================================");
    }

    public static List<String> hangManImages() {
        //big thanks to chrishorton, the man who made this ASCII art
        //the link is here
        // https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c

        List<String> images = new ArrayList<>();

        images.add("\n" +
                "==    +---+\n" +
                "==    |   |\n" +
                "==        |\n" +
                "==        |\n" +
                "==        |\n" +
                "==        |\n" +
                "==   =========");


        images.add("\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========");


        images.add(" \n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "=========");


        images.add("\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "      |\n" +
                "=========");


        images.add("\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                "      |\n" +
                "      |\n" +
                "=========");


        images.add("\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " /    |\n" +
                "      |\n" +
                "=========");


        images.add(
                "==    +---+\n" +
                        "==    |   |\n" +
                        "==    O   |\n" +
                        "==   /|\\  |\n" +
                        "==   / \\  |\n" +
                        "==        |\n" +
                        "==  =========");

        return images;


    }

    public static void youWon(){
        System.out.println("\n<><><><><><><><><><><><><><><><>");
        System.out.println("<  Congratulations!! You won!  >");
        System.out.println("<><><><><><><><><><><><><><><><>");
    }

    public static void goodBye(){
        System.out.println("\n\n");
        System.out.println("=================================");
        System.out.println("|  Thanks for playing Hangman!  |");
        System.out.println("|        Have a nice day!       |");
        System.out.println("=================================");

    }
}
