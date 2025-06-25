package com.manasi.corejava.datatypes;

/**
 * Represents a Car with properties:
 * brand (final), model, year.
 */
public class Car {
    public static final String BRAND = "Toyota";  // constant

    private String model;   // instance variable
    private int year;       // instance variable

    private static int count = 0;  // static variable (shared)

    // Constructor
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
        count++;
    }

    // Instance method
    public void displayInfo() {
        System.out.println(BRAND + " " + model + " (" + year + ")");
    }

    // Static method
    public static int getObjectCount() {
        return count;
    }

    // Getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

