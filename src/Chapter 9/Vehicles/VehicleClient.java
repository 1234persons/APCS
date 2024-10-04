package Vehicles;

import java.util.Scanner;

public class VehicleClient {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Vehicle vehicle1 = assignVehicle();
        Vehicle vehicle2 = assignVehicle();
        Vehicle vehicle3 = assignVehicle();

        System.out.println(vehicle1);
        System.out.println(vehicle2);
        System.out.println(vehicle3);

        input.close();

    }

    public static Vehicle assignVehicle() {

        String brand;
        String model;
        String userChoice;
        int year;
        int vehicleFeature;

        System.out.println("Enter the type of vehicle you would like (Car C, Truck T, Minivan M)");
        userChoice = input.nextLine();

        System.out.println("Enter the brand: ");
        brand = input.nextLine();

        System.out.println("Enter the model: ");
        model = input.nextLine();

        System.out.println("Enter the year: ");
        year = input.nextInt();

        if (userChoice.equalsIgnoreCase("C")) {

            System.out.println("Enter the size of the car in square feet: ");
            vehicleFeature = input.nextInt();
            return (new Car(brand, model, year, vehicleFeature));

        } else if (userChoice.equalsIgnoreCase("T")) {

            System.out.println("Enter the capacity of the truck in pounds: ");
            vehicleFeature = input.nextInt();
            return (new Truck(brand, model, year, vehicleFeature));
        } else {

            System.out.println("Enter the amount of seats in the minivan: ");
            vehicleFeature = input.nextInt();
            return (new Minivan(brand, model, year, vehicleFeature));
        }
    }

}
