package Chapter13;

import java.util.ArrayList;
import java.util.Scanner;

public class WorldPlay {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String word;
        do {
            System.out.println("Enter list of words, one per line");
            word = input.next();
            wordList.add(word);
        } while (!word.equals("."));

    }

    public void StackWords(ArrayList<String> wordList) {
        @SuppressWarnings("unused")
        int index = 0;
    }
}
