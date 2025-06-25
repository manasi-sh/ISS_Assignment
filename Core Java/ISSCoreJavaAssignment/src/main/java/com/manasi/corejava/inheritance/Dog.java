package com.manasi.corejava.inheritance;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating kibble.");
    }

    public void bark() {
        System.out.println("Dog barks: Woof!");
    }
}
