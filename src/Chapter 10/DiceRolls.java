import java.util.Scanner;
import java.lang.Math;

public class DiceRolls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numRolls;
        int outcome = 0;
        int diceSides;
        int numDice;

        System.out.println("How many times would you like to roll?");
        numRolls = input.nextInt();

        System.out.println("How many sides would you like on the dice?");
        diceSides = input.nextInt();

        System.out.println("How many dice would you like to roll?");
        numDice = input.nextInt();

        int[] outcomes = new int[numDice * diceSides + 1];

        for (int roll = 0; roll < numRolls; roll++) {

            for (int diceNum = 1; diceNum <= numDice; diceNum++) {
                outcome += (int) (diceSides * Math.random() + 1);
            }

            outcomes[outcome] += 1;
            outcome = 0;
        }

        for (int i = numDice; i <= outcomes.length - 1; i++) {
            System.out.println(i + ": " + outcomes[i]);
        }

        input.close();
    }
}
