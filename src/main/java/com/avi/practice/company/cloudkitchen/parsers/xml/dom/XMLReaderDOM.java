package com.avi.practice.company.cloudkitchen.parsers.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by navinash on 17/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class XMLReaderDOM {

    public void read(final String xmlFilePath) throws ParserConfigurationException, IOException, SAXException {
        final File file = new File(xmlFilePath);
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder parser = factory.newDocumentBuilder();
        final Document document = parser.parse(file);
        document.getDocumentElement().normalize();
        System.out.println(document.getDocumentElement().getNodeName());
        final NodeList nodes = document.getDocumentElement().getElementsByTagName("Employee");
        for(int i = 0; i < nodes.getLength(); i++) {
            final Node node = nodes.item(i);
            final short nodeType = node.getNodeType();
            switch (nodeType) {
                case Node.ELEMENT_NODE:
                    final Employee employee = new Employee();
                    final Element element = (Element) node;
                    final String name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                    final String age = element.getElementsByTagName("age").item(0).getChildNodes().item(0).getNodeValue();
                    final String role = element.getElementsByTagName("role").item(0).getChildNodes().item(0).getNodeValue();
                    final String gender = element.getElementsByTagName("gender").item(0).getChildNodes().item(0).getNodeValue();
                    employee.setName(name);
                    employee.setAge(Integer.parseInt(age));
                    employee.setRole(role);
                    employee.setGender(gender);
                    System.out.println(employee);
            }
        }
    }



    public static void main(String[] args) throws Exception {
        final XMLReaderDOM reader = new XMLReaderDOM();
        reader.read("/Users/navinash/repos/dailypractice/src/main/resources/employee-new.xml");
    }
}
