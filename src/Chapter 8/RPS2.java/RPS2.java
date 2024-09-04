//RSP Game
import java.util.Scanner;

// Computer plays rock paper scissors against one player

public class RPS2 {
    public static void main(String[] args) {
        RPSGame rps = new RPSGame();
        RPSPlayer rpsOpponent = new RPSPlayer();
        int rounds;
        int playerThrow;
        Scanner input = new Scanner(System.in);

        //Play rock paper scissors
        System.out.println("How many rounds?");
        rounds = input.nextInt();
        for (int i = 1; i <= rounds; i++) {
            System.out.println("Enter your throw: (Rock = 1, paper = 2, scissors = 3)");
            playerThrow = input.nextInt();
            rpsOpponent.makeThrow(playerThrow);

            rps.makeCompThrow();
            rps.announceWinner(rpsOpponent.getThrow());
        }
        rps.bigWinner();
        input.close();
    }
}
