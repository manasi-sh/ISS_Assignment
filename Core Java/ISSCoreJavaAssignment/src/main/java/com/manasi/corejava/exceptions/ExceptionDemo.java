package com.manasi.corejava.exceptions;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Checked exception – file reading
        System.out.print("Enter file path to read: ");
        String path = sc.nextLine();
        try {
            String content = readFile(path);
            System.out.println("File content:\n" + content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // 2. Runtime (unchecked) exception – input mismatch
        try {
            System.out.print("\nEnter an integer: ");
            int num = sc.nextInt();
            System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.err.println("That's not an integer!");
            sc.nextLine();
        }

        // 3. Custom exception using throw/throws
        try {
            System.out.print("\nEnter a positive number (>0): ");
            int n = sc.nextInt();
            checkPositive(n);
            System.out.println("You entered valid number: " + n);
        } catch (InvalidNumberException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        sc.close();
    }

    // Checked exception: IOException -> must declare or handle
    public static String readFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }

    // throw vs throws with custom exception
    public static void checkPositive(int n) throws InvalidNumberException {
        if (n <= 0) {
            // 'throw' explicitly creates and throws the exception
            throw new InvalidNumberException("Number must be > 0, you entered: " + n);
        }
    }
}

// Custom checked exception
class InvalidNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	
    public InvalidNumberException(String message) {
        super(message);
    }
}
