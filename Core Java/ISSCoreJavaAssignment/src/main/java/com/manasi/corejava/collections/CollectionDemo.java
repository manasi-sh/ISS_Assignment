package com.manasi.corejava.collections;

import java.util.*;

public class CollectionDemo {
    public static class Student implements Comparable<Student> {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() { return id; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return "(" + id + ", " + name + ")";
        }

        // Natural ordering by id
        @Override
        public int compareTo(Student other) {
            return this.id - other.id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- List<Integer> ---
        List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 4);
        System.out.println("Original numbers (List): " + numbers);
        Collections.sort(numbers); // natural order
        System.out.println("Sorted numbers: " + numbers);

        // --- List<Student> ---
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Priya"));
        students.add(new Student(1, "Amit"));
        students.add(new Student(2, "Sneha"));
        System.out.println("\nOriginal students (List): " + students);
        Collections.sort(students); // uses Student.compareTo()
        System.out.println("Students sorted by ID (Comparable): " + students);

        // Custom sort by name using Comparator
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted by NAME (Comparator): " + students);

        // --- Set<Student> ---
        Set<Student> studentSet = new HashSet<>(students);
        studentSet.add(new Student(2, "Sneha")); // duplicate ID but different instance
        System.out.println("\nStudents in HashSet (no duplicates by equals/hashCode): " + studentSet);

        // Sorted Set using TreeSet (uses Comparable)
        Set<Student> treeSet = new TreeSet<>(students);
        System.out.println("Students in TreeSet (sorted): " + treeSet);

        // --- Map<Student, Student> ---
        Map<Student, Student> map = new HashMap<>();
        for (Student s : students) {
            map.put(s, new Student(s.getId(), s.getName() + "Clone"));
        }
        System.out.println("\nMap entries:");
        for (Map.Entry<Student, Student> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        sc.close();
    }
}
