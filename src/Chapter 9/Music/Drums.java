
public class Drums extends Percussion {

    /*
     * constructor
     * pre: none
     * post: A cymbal object is created
     */
    public Drums(String drummer) {
      super(drummer);
    }
  
    /*
     * Returns the sound of the instrument
     */
    public String makeSound() {
      return ("boom");
    }
  
    /*
     * Returns a string representing the instrument
     */
    public String toString() {
      return (super.getMusician() + " plays " + makeSound() + ".");
    }
  }
  