package Rectangle2;

public class RectangleMain {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle();
        Rectangle rect2 = new Rectangle(5, 2);

        if (rect.equals(rect2)) {
            System.out.println("Objects are equal");
        } else {
            System.out.println("Objects are not equal");
        }

        if (rect.compareTo(rect2) == -1) {
            System.out.println("Rectangle 2 has a greater length or width");
        } else if (rect.compareTo(rect2) == 0) {
            System.out.println("The lengths or widths are not equal are equal");
        } else {
            System.out.println("Rectangle 1 has a greater length or width");
        }

        if (rect.compareArea(rect2) == -1) {
            System.out.println("Rectangle 2 has a greater area");
        } else if (rect.compareArea(rect2) == 0) {
            System.out.println("The areas are equal");
        } else {
            System.out.println("Rectangle 1 has a greater area");
        }

        System.out.println(rect);
        System.out.println(rect2);

        System.out.println("\nThe area of rectangle one is: " + rect.area());
        System.out.println("The perimeter of rectangle one is: " + rect.perimeter() + "\n");

        System.out.println("The area of rectangle two is: " + rect2.area());
        System.out.println("The perimeter of rectangle two is: " + rect2.perimeter() + "\n");

        Rectangle.displayAreaFormula();

    }
}
