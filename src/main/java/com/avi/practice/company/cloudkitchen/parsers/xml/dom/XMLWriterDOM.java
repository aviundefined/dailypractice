package com.avi.practice.company.cloudkitchen.parsers.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by navinash on 23/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class XMLWriterDOM {

    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        final Document doc = dBuilder.newDocument();
        //add elements to Document
        final Element rootElement = doc.createElementNS("https://www.journaldev.com/employee", "Employees");
        //append root element to document
        doc.appendChild(rootElement);

        //append first child element to root element
        rootElement.appendChild(getEmployee(doc, "1", "Pankaj", "29", "Java Developer", "Male"));

        //append second child
        rootElement.appendChild(getEmployee(doc, "2", "Lisa", "35", "Manager", "Female"));

        //for output to file, console
        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        final DOMSource source = new DOMSource(doc);

        //write to console or file
        final StreamResult console = new StreamResult(System.out);
        final StreamResult file = new StreamResult(new File("/Users/navinash/repos/dailypractice/src/main/resources/employee-new.xml"));

        //write data
        transformer.transform(source, console);
        transformer.transform(source, file);
    }

    private static Node getEmployee(
            final Document doc,
            final String id,
            final String name,
            final String age,
            final String role,
            final String gender) {
        final Element employee = doc.createElement("Employee");
        //set id attribute
        employee.setAttribute("id", id);
        //create name element
        employee.appendChild(getEmployeeElements(doc, "name", name));
        //create age element
        employee.appendChild(getEmployeeElements(doc, "age", age));
        //create role element
        employee.appendChild(getEmployeeElements(doc, "role", role));
        //create gender element
        employee.appendChild(getEmployeeElements(doc, "gender", gender));
        return employee;
    }


    //utility method to create text node
    private static Node getEmployeeElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
