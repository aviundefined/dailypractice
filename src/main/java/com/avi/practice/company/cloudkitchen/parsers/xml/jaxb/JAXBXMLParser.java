package com.avi.practice.company.cloudkitchen.parsers.xml.jaxb;


import com.avi.practice.company.cloudkitchen.parsers.xml.jaxb.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by navinash on 27/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JAXBXMLParser {

    public void parse(final String xmlPath) throws IOException, JAXBException {
        try(final FileInputStream is = new FileInputStream(new File(xmlPath))) {
            final Unmarshaller unmarshaller = JAXBContext.newInstance(Employee.class).createUnmarshaller();
            final Employee unmarshal = (Employee) unmarshaller.unmarshal(is);
            System.out.println(unmarshal);
        }
    }

}
