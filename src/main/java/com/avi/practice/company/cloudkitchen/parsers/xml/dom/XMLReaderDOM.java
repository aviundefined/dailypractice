package com.avi.practice.company.cloudkitchen.parsers.xml.dom;

import com.avi.practice.company.cloudkitchen.parsers.xml.Employee;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 17/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class XMLReaderDOM {

    public void read(final String xmlFilePath) throws ParserConfigurationException, IOException, SAXException {
        final File file = new File(xmlFilePath);
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("Employee");
        //now XML is loaded as Document in memory, lets convert it to Object List
        List<Employee> empList = new ArrayList<Employee>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            empList.add(getEmployee(nodeList.item(i)));
        }
        System.out.println(empList);
    }

    private  Employee getEmployee(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Employee emp = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("name", element));
            emp.setAge(Integer.parseInt(getTagValue("age", element)));
            emp.setGender(getTagValue("gender", element));
            emp.setRole(getTagValue("role", element));
        }

        return emp;
    }

    private  String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public static void main(String[] args) throws Exception {
        final XMLReaderDOM reader = new XMLReaderDOM();
        reader.read("/Users/navinash/repos/dailypractice/src/main/resources/employee.xml");

        final Map<Character, Integer> charMap = new HashMap<>();
        charMap.compute('0', (c, v) -> {
            if (v == null) {
                return 1;
            }
            return v + 1;
        });

        for(Map.Entry<Character, Integer> e :charMap.entrySet()) {
            if(e.getValue() > 1) {
                charMap.put(e.getKey(), e.getValue() - 1);
            }
        }
    }
}
