package com.avi.practice.company.cloudkitchen.parsers.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 27/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeMap {

    private Map<Integer, Employee> employees = new HashMap<>();

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeeMap{" +
                "employees=" + employees +
                '}';
    }
}
