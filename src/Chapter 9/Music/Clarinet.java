public class Clarinet extends Woodwind {
    
    /*
     * constructor
     * pre: none
     * post: A piccolo object is created
     */
    public Clarinet(String clarinetist) {
        super(clarinetist);
    }

    /*
      * Returns the sound of the instrument
      */
      public String makeSound() {
        return("squak");
      }


      /*
       * Returns a string representing the instrument
       */
      public String toString() {
        return(super.getMusician() + " plays " + makeSound() + ".");
      }
}
