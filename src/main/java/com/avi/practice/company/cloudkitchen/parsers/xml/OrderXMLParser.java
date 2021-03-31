package com.avi.practice.company.cloudkitchen.parsers.xml;


import com.avi.practice.company.cloudkitchen.parsers.model.Order;
import com.avi.practice.company.cloudkitchen.parsers.model.Orders;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 31/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OrderXMLParser {

    public static void main(String[] args) throws Exception {
        readOrderXMLViaSTaxParser();
        readOrderXMLViaJaxb();
    }

    private static void readOrderXMLViaJaxb() throws Exception {
        File file = new File("/Users/navinash/repos/dailypractice/src/main/resources/orders.xml");
        final String xsdFile = "/Users/navinash/repos/dailypractice/schema1.xsd";
        final JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(xsdFile));
        unmarshaller.setSchema(schema);

        final Orders orders = (Orders) unmarshaller.unmarshal(file);
        for(final Order o : orders.getOrder()) {
            System.out.println(o);
        }
        System.out.println("--------------");
    }
    private static void readOrderXMLViaSTaxParser() throws XMLStreamException, FileNotFoundException {
        File file = new File("/Users/navinash/repos/dailypractice/src/main/resources/orders.xml");

        // Instance of the class which helps on reading tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Initializing the handler to access the tags in the XML file
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        //All read Orders objects will be added to this list
        List<Order> OrderList = new ArrayList<>();

        //Create Order object. It will get all the data using setter methods.
        //And at last, it will stored in above 'OrderList'
        Order Order = null;

        // Checking the availability of the next tag
        while (eventReader.hasNext())
        {
            XMLEvent xmlEvent = eventReader.nextEvent();

            if (xmlEvent.isStartElement())
            {
                StartElement startElement = xmlEvent.asStartElement();

                //As soo as Order tag is opened, create new Order object
                if("row".equalsIgnoreCase(startElement.getName().getLocalPart())) {
                    Order = new Order();
                }

                //Read all attributes when start tag is being read

                //Now everytime content tags are found;
                //Move the iterator and read data
                switch (startElement.getName().getLocalPart())
                {
                    case "id":
                        Characters idDataEvent = (Characters) eventReader.nextEvent();
                        Order.setId(idDataEvent.getData());
                        break;

                    case "name":
                        Characters nameDataEvent = (Characters) eventReader.nextEvent();
                        Order.setName(nameDataEvent.getData());
                        break;

                    case "temp":
                        Characters tempDataEvent = (Characters) eventReader.nextEvent();
                        Order.setTemp(tempDataEvent.getData());
                        break;
                    case "shelfLife":
                        Characters shelfLifeDataEvent = (Characters) eventReader.nextEvent();
                        Order.setShelfLife(Double.parseDouble(shelfLifeDataEvent.getData()));
                        break;
                    case "decayRate":
                        Characters decayRateDataEvent = (Characters) eventReader.nextEvent();
                        Order.setDecayRate(Double.parseDouble(decayRateDataEvent.getData()));
                        break;
                }
            }

            if (xmlEvent.isEndElement())
            {
                EndElement endElement = xmlEvent.asEndElement();

                //If Order tag is closed then add the Order object to list;
                //and be ready to read next Order data
                if("row".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    OrderList.add(Order);
                }
            }
        }

        System.out.println(OrderList);   //Verify read data
        System.out.println("--------------");
    }
}
