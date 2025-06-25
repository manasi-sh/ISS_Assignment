package com.manasi.corejava.inheritance;

public class Rectangle extends Shape implements Movable {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void move(double x, double y) {
        System.out.printf("Rectangle moved by (%.2f, %.2f)\n", x, y);
    }
}
