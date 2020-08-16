package hangman;

import java.util.ArrayList;
import java.util.List;

public class GameUtilities {

    public static List<Character> getSplitTheWord(String word){
        List<Character> wordLetters = new ArrayList<>();
        char letter;

        for (int i = 0; i < word.length(); i++) {
            wordLetters.add(word.charAt(i));
        }

        return wordLetters;
    }

    public static List<Character> getBlindWord(String word){
        List<Character> blindLetters = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            blindLetters.add('_');
        }

        return blindLetters;
    }


    public static String getBlindWordString(List<Character> blindLetters){

        String word = "";
        for (Character blindLetter : blindLetters) {
            word += blindLetter;
        }

        return word;
    }


    public static void printBlindWord(List<Character> blindLetters){
        for (int i = 0; i < blindLetters.size() - 1; i++) {
            System.out.print(blindLetters.get(i) + " ");
        }
        System.out.print(blindLetters.get(blindLetters.size() -1) + "\n"); //done just for a better output format
    }




}
