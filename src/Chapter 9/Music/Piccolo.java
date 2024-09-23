public class Piccolo extends Woodwind {
    
    /*
     * constructor
     * pre: none
     * post: A piccolo object is created
     */
    public Piccolo(String piccoloist) {
        super(piccoloist);
    }

    /*
      * Returns the sound of the instrument
      */
      public String makeSound() {
        return("peep");
      }


      /*
       * Returns a string representing the instrument
       */
      public String toString() {
        return(super.getMusician() + " plays " + makeSound() + ".");
      }
}
