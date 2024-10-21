import java.util.Scanner;

public class CountLetters {
    public static void main(String[] args) {

        final int LOW = 'A';
        final int HIGH = 'Z';
        int[] letterCounts = new int[HIGH - LOW + 1];

        Scanner input = new Scanner(System.in);
        String word;
        char[] wordLetters;
        int offset;

        // Prompt the user for a word
        System.out.println("Enter a word: ");
        word = input.nextLine().toUpperCase().replaceAll(" ", "").replaceAll("[^a-zA-Z]", "");

        wordLetters = word.toCharArray();

        for (int letter = 0; letter < wordLetters.length; letter++) {
            offset = wordLetters[letter] - LOW;
            letterCounts[offset] += 1;
        }

        for (int i = LOW; i <= HIGH; i++) {
            System.out.println((char) i + ": " + letterCounts[i - LOW]);
        }

        input.close();
    }
}
