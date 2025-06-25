package com.manasi.corejava.stringsarrays;

import java.util.Arrays;
import java.util.Scanner;

public class StringArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- String Operations ---
        System.out.print("Enter a phrase or sentence: ");
        String inputStr = sc.nextLine();

        System.out.println("\nString Analysis:");
        System.out.println("Original: " + inputStr);
        System.out.println("Length: " + inputStr.length());
        System.out.println("Uppercase: " + inputStr.toUpperCase());
        System.out.println("Trimmed: '" + inputStr.trim() + "'");
        System.out.println("Does it contain 'Java'? " + inputStr.contains("Java"));
        System.out.println("Replace spaces with underscores: " + inputStr.replace(" ", "_"));

        // --- Array Operations ---
        System.out.print("\nHow many exam marks will you enter? ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark #" + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            sum += marks[i];
        }

        System.out.println("\nMarks entered: " + Arrays.toString(marks));

        // Average
        double average = (n > 0) ? (double) sum / n : 0;
        System.out.println("Average marks: " + average);

        // Max and Min
        int max = Arrays.stream(marks).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(marks).min().orElse(Integer.MAX_VALUE);
        System.out.println("Highest mark: " + max);
        System.out.println("Lowest mark: " + min);

        sc.close();
    }
}
