package com.manasi.corejava.inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        // Abstraction & Polymorphism with Shape
        Shape circle = new Circle("Red", 3.0);
        Shape rectangle = new Rectangle("Blue", 4.0, 5.0);

        System.out.println("Circle color: " + circle.getColor());
        System.out.printf("Circle area: %.2f\n", circle.area());
        ((Circle) circle).move(2, 3);

        System.out.println("Rectangle color: " + rectangle.getColor());
        System.out.printf("Rectangle area: %.2f\n", rectangle.area());
        ((Rectangle) rectangle).move(-1, 4);

        System.out.println("\n--- Animal Hierarchy ---");
        Animal animal = new Animal();
        animal.eat();

        Dog dog = new Dog();
        dog.eat();  // Overridden method
        dog.bark();

        Animal poly = new Dog();
        poly.eat(); // Polymorphic call to Dog.eat()
    }
}
