package Vehicles;

public class Minivan extends Vehicle {
    
    int seatNum;

    public Minivan(String brand, String model, int year, int seatNum) {
        super(brand, model, year);
        this.seatNum = seatNum;
    }

    public int getSeatNum() {
        return(seatNum);
    }

    public void setSeatNum(int capacity) {
        this.seatNum = capacity;
    }

    public String toString() {
        return("The minivan's brand is " + super.getBrand() + ", the model is " + super.getModel() + 
                ", the year is " + super.getYear() + " and the truncks capacity is " + seatNum);
    }

}
