package com.avi.practice.company.cloudkitchen.parsers.xml.jaxb;

import com.avi.practice.company.cloudkitchen.parsers.xml.jaxb.model.Department;
import com.avi.practice.company.cloudkitchen.parsers.xml.jaxb.model.Employee;
import com.avi.practice.company.cloudkitchen.parsers.xml.jaxb.model.EmployeeMap;
import com.avi.practice.company.cloudkitchen.parsers.xml.jaxb.model.Hobbies;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 27/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JaxbExample {

    public static void main(String[] args) throws JAXBException, IOException, SAXException {
        objToXmlWithoutXmlRootElement();
        xmlToObjWithoutXmlRootElement();
        xmlToObj();
        objToXml();
        mapToXml();
        xmlToMap();
    }

    private static void xmlToObjWithoutXmlRootElement() throws JAXBException, FileNotFoundException {
        final String path = "/Users/navinash/repos/dailypractice/src/main/resources/jaxb/employee.xml";
        final JAXBContext context = JAXBContext.newInstance(Employee.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        // To format XML
        final JAXBElement<Employee> unmarshal = unmarshaller.unmarshal(new StreamSource(new FileInputStream(new File(path))), Employee.class);
        final Employee value = unmarshal.getValue();
        System.out.println(value);
    }

    private static void objToXmlWithoutXmlRootElement() throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(Employee.class);
        final Marshaller marshaller = context.createMarshaller();
        // To format XML
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        final Employee employee = new Employee(1, "Avinash", "Nigam", new Department(1, "Engineering"));
        employee.setHobbies(new Hobbies(Arrays.asList("Cricket", "Guitar", "Music")));
        final JAXBElement<Employee> element = new JAXBElement<>(new QName("", "employee"), Employee.class, employee);
        marshaller.marshal(element, System.out);
    }

    private static void xmlToMap() throws JAXBException {
        final String path = "/Users/navinash/repos/dailypractice/src/main/resources/jaxb/employees.xml";
        final JAXBContext context = JAXBContext.newInstance(EmployeeMap.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final EmployeeMap unmarshal = (EmployeeMap) unmarshaller.unmarshal(new File(path));
        System.out.println(unmarshal);

    }

    private static void mapToXml() throws JAXBException {
        Map<Integer, Employee> map = new HashMap<>();

        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstName("Lokesh");
        emp1.setLastName("Gupta");

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setFirstName("John");
        emp2.setLastName("Mclane");

        map.put(1, emp1);
        map.put(2, emp2);

        //Add employees in map
        EmployeeMap employeeMap = new EmployeeMap();
        employeeMap.setEmployees(map);

        /******************** Marshalling example *****************************/

        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(employeeMap, new File("/Users/navinash/repos/dailypractice/src/main/resources/jaxb/employees.xml"));
    }

    private static void xmlToObj() throws JAXBException, IOException, SAXException {
        final String path = "/Users/navinash/repos/dailypractice/src/main/resources/jaxb/employee.xml";
        final String xsdFile = "/Users/navinash/repos/dailypractice/schema1.xsd";
        final JAXBContext context = JAXBContext.newInstance(Employee.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        //Setup schema validator
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema employeeSchema = sf.newSchema(new File(xsdFile));
        unmarshaller.setSchema(employeeSchema);

        try (final InputStream is = new FileInputStream(new File(path))) {
            final Employee employee = (Employee) unmarshaller.unmarshal(is);
            System.out.println(employee);
        }
    }

    private static void objToXml() throws JAXBException {
        final Employee employee = new Employee(1, "Avinash", "Nigam", new Department(1, "Engineering"));
        employee.setHobbies(new Hobbies(Arrays.asList("Cricket", "Guitar", "Music")));
        final JAXBContext context = JAXBContext.newInstance(Employee.class);
        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(employee, new File("/Users/navinash/repos/dailypractice/src/main/resources/jaxb/employee.xml"));
    }
}
