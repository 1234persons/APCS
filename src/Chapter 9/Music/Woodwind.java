abstract class Woodwind extends Instrument {
    

    /*
     * constructor
     * pre: none
     * post: woodwind player created
     */

     public Woodwind(String player) {
        super(player);
     }

     /*
      * Returns the sound of the instrument
      */
      public String makeSound() {
        return("toot");
      }

}