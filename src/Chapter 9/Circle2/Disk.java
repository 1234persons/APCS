package Circle2;

public class Disk extends Circle implements Comparable {
    private double thickness;

    /*
     * constructor
     * pre: none
     * post: creates disk object with radius r and double t
     */

    public Disk(double r, double t) {
        super(r);
        thickness = t;
    }

    /*
     * Changes thickness of the disk
     * pre: none
     * post: thickness is changed
     */

    public void setThickness(double newThickness) {
        thickness = newThickness;
    }

    /*
     * Returns the thickness of the disk
     * pre: none
     * post: thickness is returned
     */

    public double getThickness() {
        return (thickness);
    }

    /*
     * Return the disk's volume
     * pre: none
     * post: the volume of the disk is returned
     */

    public double volume() {
        double v = super.area() * thickness;
        return(v);
    }

    /*
     * Determines if the object is equal to another disk object
     * pre: disk d is an object
     * post: equality is determined
     */

     public boolean equals(Object d) {

        Disk testObj = (Disk) d;

        if (testObj.getRadius() == super.getRadius() && testObj.getThickness() == thickness) {
            return (true);
        } else {
            return (false);
        }

        

    }

    /*
     * Returns a string representing the string object
     * pre: none
     * post: a string representing the string object is returned
     */

    public String toString() {
        String diskString;

        diskString = "The disk has a radius " + super.getRadius() + " and a thickness of " + thickness + ".";

        return (diskString);
    }

    public int compareTo(Object d) {
        Disk testDisk = (Disk)d;

        if(super.getRadius() < testDisk.getRadius() || thickness < testDisk.getThickness()) {
            return(-1);
        } else if (super.getRadius() == testDisk.getRadius() && thickness == testDisk.getThickness()) {
            return(0);
        } else {
            return(1);
        }
    }
}
