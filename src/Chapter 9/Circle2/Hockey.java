package Circle2;

public class Hockey {
    public static void main(String[] args) {
        Puck hockeyPuck = new Puck(5);

        System.out.println("The puck has a radius of: " + hockeyPuck.getRadius());
        System.out.println("The puck has a thickness of: " + hockeyPuck.getThickness());
        System.out.println("The puck has a weight of: " + hockeyPuck.getWeight());
        System.out.println("The pucks division is: " + hockeyPuck.getDivision());

        Puck puck1 = new Puck(4.5);
        Puck puck2 = new Puck(5.5);

        if (puck1.equals(puck2)) {
            System.out.println("The objects are equal");
        } else {
            System.out.println("The objects are not equal");
        }
        
        System.out.println(puck1);
        System.out.println(puck2);
    }
}
