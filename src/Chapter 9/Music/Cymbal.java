
public class Cymbal extends Percussion {
    
    /*
     * constructor
     * pre: none
     * post: A cymbal object is created
     */
    public Cymbal(String cymbalist) {
        super(cymbalist);
    }

    /*
      * Returns the sound of the instrument
      */
      public String makeSound() {
        return("crash");
      }


      /*
       * Returns a string representing the instrument
       */
      public String toString() {
        return(super.getMusician() + " plays " + makeSound() + ".");
      }
}
