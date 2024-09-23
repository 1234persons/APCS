abstract class Percussion extends Instrument {
    

    /*
     * constructor
     * pre: none
     * post: percussionist created
     */

     public Percussion(String player) {
        super(player);
     }

     /*
      * Returns the sound of the instrument
      */
      public String makeSound() {
        return("toot");
      }

}
