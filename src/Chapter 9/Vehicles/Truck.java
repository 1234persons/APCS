package Vehicles;

public class Truck extends Vehicle {

    int capacity;

    public Truck(String brand, String model, int year, int capacity) {
        super(brand, model, year);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return(capacity);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return("The truck's brand is " + super.getBrand() + ", the model is " + super.getModel() + 
                ", the year is " + super.getYear() + " and the trucks capacity is " + capacity + " pounds");
    }

}
