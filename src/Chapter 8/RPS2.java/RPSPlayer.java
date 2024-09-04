//Models player in RPS

public class RPSPlayer {
    private int playerThrow; // rock = 1, paper = 2, scissors = 3

    /*
     * constructor
     * pre: none
     * post: RSP player object created. The player is given a default throw
     */

    public RPSPlayer() {
        playerThrow = 1; // Default throw
    }

    /*
     * Sets the player throw
     * pre: newThrow is the integer equal to 1, 2, or 3
     * post: RPS
     */

     public void makeThrow(int newThrow) {
        playerThrow = newThrow;
     }

     /*
      * Returns players throw
      pre: none
      post: Player's throw has been returned
      */
      public int getThrow() {
        return(playerThrow);
      }

}
