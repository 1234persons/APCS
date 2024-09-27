package Rectangle2;

public class Rectangle implements Comparable, ComparableArea {

    private double width;
    private double length;

    public Rectangle() {
        width = 1;
        length = 1;
    }

    public Rectangle(double newWidth, double newLength) {
        width = newWidth;
        length = newLength;
    }

    public double getLength() {
        return(length);
    }

    public double getWidth() {
        return(width);
    }

    public double area() {
        return (length * width);
    }

    public double perimeter() {
        return (2 * length + 2 * width);
    }

    public static void displayAreaFormula() {
        System.out.println("The formula for the area of a rectangle is Width * Length");
    }

    public String toString() {
        String rectangleString;

        rectangleString = "This rectangle has a length of " + length + " and a width of " + width;

        return (rectangleString);
    }

    public interface ComparableArea {
        int compareArea(Object r);
    }

    public boolean equals(Object R) {

        Rectangle testObj = (Rectangle)R;

        if (testObj.getLength() == length && testObj.getWidth() == width) {
            return(true);
        } else {
            return(false);
        }

    }

    public int compareTo(Object r) {
        Rectangle testRect = (Rectangle)r;

        if(width < testRect.getWidth() && length < testRect.getLength()) {
            return(-1);
        } else if (width == testRect.getWidth() && length == testRect.getLength()) {
            return(0);
        } else {
            return(1);
        }
    }

    public int compareArea(Object r) {
        Rectangle testRect = (Rectangle)r;

        if(area() < testRect.area() && area() < testRect.area()) {
            return(-1);
        } else if (area() == testRect.area() && area() == testRect.area()) {
            return(0);
        } else {
            return(1);
        }
    }
}
