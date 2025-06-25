package com.manasi.corejava.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;
import java.util.*;

public class XmlDemo {
    // A simple POJO for XML mapping
    public static class Person {
        public int id;
        public String name;
        public List<String> hobbies;

        // default constructor
        public Person() {}

        public Person(int id, String name, List<String> hobbies) {
            this.id = id;
            this.name = name;
            this.hobbies = hobbies;
        }

        @Override
        public String toString() {
            return "Person{id=" + id +
                   ", name='" + name + '\'' +
                   ", hobbies=" + hobbies + '}';
        }
    }

    public static void main(String[] args) throws IOException {
        XmlMapper mapper = new XmlMapper();

        // Java → XML
        Person p = new Person(1, "Meera", Arrays.asList("Music", "Dance"));
        String xml = mapper.writerWithDefaultPrettyPrinter()
                           .writeValueAsString(p);
        System.out.println("Serialized XML:\n" + xml);

        // XML → Java
        String inputXml = xml;
        Person p2 = mapper.readValue(inputXml, Person.class);
        System.out.println("Deserialized Person: " + p2);
    }
}
