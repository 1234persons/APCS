
//Models game of RPS
import java.lang.Math;

public class RPSGame {
    public static final int ROCK = 1, PAPER = 2, SCISSORS = 3;
    private int compThrow;
    private int playerWins = 0, computerWins = 0;

    /*
     * constructor
     * pre: none
     * post: RPSGame object created. Computer throw generated
     */

     public RPSGame() {
        compThrow = (int)(3*Math.random() + 1); // Computer throws 1, 2, or 3
        playerWins = 0;
        computerWins = 0;
     }

     /*
      * Computers throw is generated (ROCK, PAPER, or SCISSORS)
      * Pre: none
      * Post: Computers throw has been made.
      */

      public void makeCompThrow() {
        compThrow = (int)(3*Math.random() + 1); // Computer throws 1, 2, or 3
      }

      /*
       * Returns comp throw
       * pre: none
       * post: Computers throw has been returned
       */

       public int getThrow() {
        return(compThrow);
       }

       /*
        * Determines winner of the round
        * pre: playerThrow is the integer 1, 2, or 3
        * post: Displays a message indicating throws. Compares player's throw to
        * computer's throw and displays a message indicating the winner.
        */

        public void announceWinner(int playerThrow) {
            // Inform player of throws
            System.out.print("You throw: ");
            switch(playerThrow) {
                case ROCK: System.out.println("rock."); break;
                case PAPER: System.out.println("paper."); break;
                case SCISSORS: System.out.println("scissors."); break;
            }

            //Determine and announce winner

            if(playerThrow == ROCK && compThrow == ROCK) {
                System.out.println("It's a draw.");
            } else if (playerThrow == ROCK && compThrow == PAPER) {
                System.out.println("Computer Wins.");
                computerWins += 1;
            } else if (playerThrow == ROCK && compThrow == SCISSORS) {
                System.out.println("You Win.");
                playerWins += 1;
            }

            if(playerThrow == PAPER && compThrow == PAPER) {
                System.out.println("It's a draw.");
            } else if (playerThrow == PAPER && compThrow == SCISSORS) {
                System.out.println("Computer Wins.");
                computerWins += 1;
            } else if (playerThrow == PAPER && compThrow == ROCK) {
                System.out.println("You Win.");
                playerWins += 1;
            }

            if(playerThrow == SCISSORS && compThrow == SCISSORS) {
                System.out.println("It's a draw.");
            } else if (playerThrow == SCISSORS && compThrow == ROCK) {
                System.out.println("Computer Wins.");
                computerWins += 1;
            } else if (playerThrow == SCISSORS && compThrow == PAPER) {
                System.out.println("You Win.");
                playerWins += 1;
            }

        }
        /*
         * Displays overall winner
         * pre: none
         * post: Computer and player wins compared and overall winner is shown
        */

        public void bigWinner() {
            if (computerWins > playerWins) {
                System.out.println("Computer wins.");
            } else if (playerWins > computerWins) {
                System.out.println("You win.");
            } else {
                System.out.println("It's a draw.");
            }
        }

}
