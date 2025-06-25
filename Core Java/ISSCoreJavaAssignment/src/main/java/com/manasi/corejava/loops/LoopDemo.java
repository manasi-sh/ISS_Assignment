package com.manasi.corejava.loops;

import java.util.Scanner;

public class LoopDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for a positive integer
        System.out.print("Enter a positive integer (n): ");
        int n = sc.nextInt();

        // Decision making: check range
        if (n <= 0) {
            System.out.println("Invalid input. Please enter a number greater than 0.");
            sc.close();
            return;
        }

        // Decision and loop: even/odd for numbers 1..n
        System.out.println("\nEven/Odd Check from 1 to " + n);
        for (int i = 1; i <= n; i++) {
            String label = (i % 2 == 0) ? "Even" : "Odd";
            System.out.println(i + " → " + label);
        }

        // Loop: sum of numbers from 1 to n
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("\nSum from 1 to " + n + " = " + sum);

        // Do-while: confirm with user
        int choice;
        do {
            System.out.print("\nDo you want to see the countdown from " + n + "? (1 = Yes, 0 = No): ");
            choice = sc.nextInt();
        } while (choice != 0 && choice != 1);

        if (choice == 1) {
            System.out.println("\nCountdown:");
            do {
                System.out.println(n);
                n--;
            } while (n > 0);
        } else {
            System.out.println("Skipping countdown.");
        }

        sc.close();
    }
}
