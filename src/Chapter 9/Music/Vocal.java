public class Vocal extends Instrument {
    

    /*
     * constructor
     * pre: none
     * post: vocalist created
     */

     public Vocal(String singerName) {
        super(singerName);
     }

     /*
      * Returns the sound of the singer
      */
      public String makeSound() {
        return("lalala");
      }


      /*
       * Returns a string representing the instrument
       */
      public String toString() {
        return(super.getMusician() + " sings " + makeSound() + ".");
      }
}
