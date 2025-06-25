package com.manasi.corejava.basics;

import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        Student student = new Student(roll, name);
        System.out.println("\nStudent created:");
        student.display();

        System.out.print("\nUpdate name to: ");
        String newName = sc.nextLine();
        student.setName(newName);

        System.out.println("\nAfter update:");
        student.display();

        sc.close();
    }
}
