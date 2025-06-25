package com.manasi.corejava.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo {
    private static final String URL = "jdbc:mysql://localhost:3307/demo?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tableSql = "CREATE TABLE IF NOT EXISTS students (" +
                          "id INT PRIMARY KEY AUTO_INCREMENT," +
                          "name VARCHAR(50)," +
                          "age INT)";
        
        String insertSql = "INSERT INTO students (name, age) VALUES (?, ?)";
        String selectSql = "SELECT id, name, age FROM students";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement()
        ) {
            // Create table
            stmt.execute(tableSql);
            System.out.println("Table ready.");

            // Insert a student
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();

            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setString(1, name);
                ps.setInt(2, age);
                int rows = ps.executeUpdate();
                System.out.println(rows + " row(s) inserted.");
            }

            // Read and display students
            try (ResultSet rs = stmt.executeQuery(selectSql)) {
                System.out.println("\nCurrent students:");
                while (rs.next()) {
                    System.out.printf("%d → %s (age %d)%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
