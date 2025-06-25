package com.manasi.corejava.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class JsonDemo {
    // POJO for JSON mapping
    public static class Employee {
        private int id;
        private String name;
        private List<String> skills;

        public Employee() {}  // default constructor needed for Jackson

        public Employee(int id, String name, List<String> skills) {
            this.id = id;
            this.name = name;
            this.skills = skills;
        }

        // getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public List<String> getSkills() { return skills; }
        public void setSkills(List<String> skills) { this.skills = skills; }

        @Override
        public String toString() {
            return "Employee{" +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   ", skills=" + skills +
                   '}';
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Example object → JSON
        Employee emp = new Employee(1001, "Anita", Arrays.asList("Java","SQL","Git"));
        String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        System.out.println("Serialized JSON:\n" + jsonStr);

        // JSON → Java object
        String jsonInput = "{\"id\":1002,\"name\":\"Rohit\",\"skills\":[\"JavaScript\",\"HTML\"]}";
        Employee emp2 = mapper.readValue(jsonInput, Employee.class);
        System.out.println("Deserialized Employee: " + emp2);

        // JSON array → List<Employee>
        String arrJson = "[" + jsonStr + "," + jsonInput + "]";
        List<Employee> emps = mapper.readValue(
            arrJson, mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
        System.out.println("List from JSON array: " + emps);
    }
}
