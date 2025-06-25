package com.manasi.corejava.filereadwrite;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FilereadwriteDemo {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Prepare sample input if not exists
        createSampleInput(inputFile);

        // --- Read using BufferedReader ---
        System.out.println("Reading lines from " + inputFile);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("IN: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // --- Read via Files utility ---
        try {
            List<String> all = Files.readAllLines(Paths.get(inputFile));
            System.out.println("\nRead with Files.readAllLines:");
            all.forEach(l -> System.out.println(">> " + l));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- Write to file with BufferedWriter ---
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("This is line 1\n");
            bw.write("This is line 2\n");
            bw.write("Written via BufferedWriter\n");
            System.out.println("\nWritten to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- Verify write by reading output file ---
        System.out.println("\nContent of " + outputFile + ":");
        try {
            Files.lines(Paths.get(outputFile)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create sample input file if missing
    private static void createSampleInput(String path) {
        File f = new File(path);
        if (f.exists()) return;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write("Hello World");
            bw.newLine();
            bw.write("Java File I/O demo!");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
