package Circle2;

public class Puck extends Disk {
    private double weight;
    private boolean standard;

    public Puck(double weight) {
        super(3, 1);
        this.weight = weight;

        if (weight >= 5) {
            standard = true;
        }
    }

    public double getWeight() {
        return(weight);
    }

    public String getDivision() {
        if(standard) {
            return("This puck is standard sized");
        } else {
            return("This puck is youth sized");
        }
    }

    public boolean equals(Object d) {

        Puck testObj = (Puck) d;

        if (testObj.getRadius() == super.getRadius() && testObj.getThickness() == super.getThickness() && testObj.getWeight() == weight) {
            return (true);
        } else {
            return (false);
        }

    }

    public String toString() {
        String diskString;

        diskString = "The puck has a radius " + super.getRadius() + ", a thickness of " + super.getThickness() + ", and weighs " + weight;

        return (diskString);
    }

}
