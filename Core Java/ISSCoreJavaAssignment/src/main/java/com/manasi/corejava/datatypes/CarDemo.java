package com.manasi.corejava.datatypes;

import java.util.Scanner;

public class CarDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter model name: ");
        String model = sc.nextLine();

        System.out.print("Enter manufacturing year: ");
        int year = sc.nextInt();

        // Local variables
        double price = 25000.50;
        int mileage = 15;

        // Create Car object using constructor
        Car car = new Car(model, year);

        System.out.println("\nCar Details:");
        car.displayInfo();
        System.out.println("Price: $" + price);
        System.out.println("Mileage: " + mileage + " km/l");

        // Show static behavior
        System.out.println("\nNumber of Car objects created: " + Car.getObjectCount());

        // Modify instance variable using setter
        sc.nextLine(); // consume newline
        System.out.print("\nEnter new model to update: ");
        String newModel = sc.nextLine();
        car.setModel(newModel);

        System.out.println("\nAfter update:");
        car.displayInfo();

        System.out.println(
            "\nTotal Car objects so far: " + Car.getObjectCount()
        );

        sc.close();
    }
}
