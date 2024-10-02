package Vehicles;

public class Car extends Vehicle{
    
    int size;

    public Car(String brand, String model, int year, int size) {
        super(brand, model, year);
        this.size = size;
    }

    public int getSize() {
        return(size);
    }

    public void setSize(int capacity) {
        this.size = capacity;
    }

    public String toString() {
        return("The car's brand is " + super.getBrand() + ", the model is " + super.getModel() + 
                ", the year is " + super.getYear() + " and the truncks capacity is " + size + " square feet.");
    }

}
