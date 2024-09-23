abstract class Woodwind extends Instrument {
    

    /*
     * constructor
     * pre: none
     * post: vocalist created
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