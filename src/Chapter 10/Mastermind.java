import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pegNum;
        int colorNum;
        int guessCount = 1;

        do {
            System.out.println("Enter the amount of pegs you would like (1-10): ");
            pegNum = input.nextInt();
        } while (pegNum > 10 || pegNum < 1);

        do {
            System.out.println("Enter the amount of colors you would like (1-9): ");
            colorNum = input.nextInt();
        } while (colorNum > 9 || colorNum < 1);

        int[] solution = new int[pegNum];

        for (int i = 0; i < solution.length; i++) {
            solution[i] = (int) ((colorNum - 1) * Math.random() + 1);
        }

        int[] guesses = new int[pegNum];

        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i]);
        }
        System.out.println();

        do {
            System.out.println("Guess " + guessCount + ": ");

            for (int i = 0; i < guesses.length; i++) {
                do {
                System.out.print("Peg " + (i + 1) + ": ");
                guesses[i] = input.nextInt();
                } while (guesses[i] < 0 || guesses[i] > 10);
            }

            pegCheck(guesses, solution);

            guessCount += 1;
        } while (!gameOver(guesses, solution));
        System.out.println("You won in " + guessCount + " guesses!");
        input.close();

    }

    public static boolean gameOver(int[] playerGuess, int[] solution) {
        for (int i = 0; i < playerGuess.length; i++) {
            if (playerGuess[i] != solution[i]) {
                return (false);
            }
        }
        return (true);
    }

    public static void pegCheck(int[] guesses, int[] solution) {

        int correctPegNumAndColor = 0;
        int correctColorNumNotPosition = 0;
        int[] tempSolution = solution.clone();
        int[] tempGuess = guesses.clone();

        for (int i = 0; i < guesses.length; i++) {
            if (tempGuess[i] == tempSolution[i]) {
                correctPegNumAndColor += 1;
                tempSolution[i] = 10;
                tempGuess[i] = 11;
            }
        }

        for (int i = 0; i < guesses.length; i++) {
            for (int j = 0; j < tempSolution.length; j++) {
                if (tempGuess[i] == tempSolution[j]) {
                    correctColorNumNotPosition += 1;
                    // tempSolution[i] = 10;
                    // tempGuess[i] = 11;
                }
            }
        }

        System.out.println("There are " + correctPegNumAndColor + " correct pegs and colors but " + correctColorNumNotPosition + " correct colors and not pegs.");
    }
}