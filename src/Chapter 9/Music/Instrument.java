abstract class Instrument {
    String musician;

    /*
     * Constructor
     * pre: none
     * post: musician assigned to the instrument
     */

    public Instrument(String name) {
        musician = name;
    }

    /*
     * Returns name of musician
     */
    public String getMusician() {
        return(musician);
    }

    /*
     * Returns sound of instrument
     * pre: none
     * post: sound of instrument returned
     */

    abstract String makeSound();

}
