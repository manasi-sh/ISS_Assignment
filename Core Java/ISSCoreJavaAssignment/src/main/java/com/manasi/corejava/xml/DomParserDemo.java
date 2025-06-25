package com.manasi.corejava.xml;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class DomParserDemo {
    public static void main(String[] args) {
        try {
            String xml = "<person><id>2</id><name>Raju</name><hobbies><hobby>Cricket</hobby><hobby>Coding</hobby></hobbies></person>";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

            Element root = doc.getDocumentElement();
            int id = Integer.parseInt(root.getElementsByTagName("id").item(0).getTextContent());
            String name = root.getElementsByTagName("name").item(0).getTextContent();

            System.out.println("Parsed via DOM → id: " + id + ", name: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
