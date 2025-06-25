package com.manasi.corejava.inheritance;

public class Circle extends Shape implements Movable {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void move(double x, double y) {
        System.out.printf("Circle moved by (%.2f, %.2f)\n", x, y);
    }
}
