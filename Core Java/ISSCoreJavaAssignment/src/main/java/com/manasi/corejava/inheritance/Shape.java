package com.manasi.corejava.inheritance;

/**
 * Abstract class representing a geometric shape.
 */
public abstract class Shape {
    private String color;  // encapsulated field

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public abstract double area();
}
