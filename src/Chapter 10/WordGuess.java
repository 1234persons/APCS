import java.util.Scanner;

/**
 * Plays a word guessing game with one player.
 */
public class WordGuess {

    public static void main(String[] args) {
        final String SECRET_WORD = "BRAIN";
        final String FLAG = "!";
        int score = 100;
        String wordSoFar = "", updatedWord = "";
        String letterGuess, wordGuess = "";
        int numGuesses = 0;
        String[] letterGuesses = new String[10];
        Scanner input = new Scanner(System.in);

        /* begin game */
        System.out.println("WordGuess game.\n");
        for (int i = 0; i < SECRET_WORD.length(); i++) {
            wordSoFar += "-"; // word as dashes
        }
        System.out.println(wordSoFar + "\n"); // display dashes

        /* allow player to make guesses */
        do {
            do {
            System.out.print("Enter a letter (" + FLAG + " to guess entire word): ");
            letterGuess = input.nextLine().substring(0,1);
            letterGuess = letterGuess.toUpperCase();
            } while (!alreadyGuessed(letterGuess, letterGuesses));
            letterGuesses[numGuesses] = letterGuess;
            /* increment number of guesses */
            numGuesses += 1;

            /*
             * player correctly guessed a letter--extract string in wordSoFar up to the
             * letter
             * guessed and then append guessed letter to that string. Next, extract rest of
             * wordSoFar and append after the guessed letter
             */
            if (SECRET_WORD.indexOf(letterGuess) >= 0) {
                updatedWord = wordSoFar.substring(0, SECRET_WORD.indexOf(letterGuess));
                updatedWord += letterGuess;
                updatedWord += wordSoFar.substring(SECRET_WORD.indexOf(letterGuess) + 1, wordSoFar.length());
                wordSoFar = updatedWord;
            }

            /* display guessed letter instead of dash */
            System.out.println(wordSoFar + "\n");
            score -= 10;
        } while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD) && score > 0);

        /* finish game and display message and number of guesses */
        if (letterGuess.equals(FLAG)) {
            System.out.println("What is your guess? ");
            wordGuess = input.nextLine();
            wordGuess = wordGuess.toUpperCase();
        }
        if (wordGuess.equals(SECRET_WORD) || wordSoFar.equals(SECRET_WORD)) {
            System.out.println("You won!");
        } else {
            System.out.println("Sorry. You lose.");
        }
        if (score == 0) {
            System.out.println("Your score is 0. You lose.");
        }
        System.out.println("The secret word is " + SECRET_WORD);
        System.out.println("You made " + numGuesses + " guesses.");
        System.out.println("Your score is " + score);
        input.close();
    }

    private static boolean alreadyGuessed(String letterGuessed, String[] guesses) {
        
        for (int i = 0; i < guesses.length; i++) {
            if (letterGuessed.equals(guesses[i])) {
                System.out.println("You already guessed " + letterGuessed + " try again.");
                return (false);  
            } 
        }
        letterGuessed += letterGuessed;
        return(true);
    }
}
