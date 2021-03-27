package com.avi.practice.company.cloudkitchen.parsers.xml.jaxb.model;

import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by navinash on 27/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable {


    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;

    private Department department;

    private Hobbies hobbies;

    public Employee() {
    }

    public Employee(int id, String fName, String lName, Department department) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    // Invoked by Marshaller after it has created an instance of this object.
    boolean beforeMarshal(Marshaller marshaller) {
        System.out.println("Before Marshaller Callback");
        return true;
    }

    // Invoked by Marshaller after it has marshalled all properties of this object.
    void afterMarshal(Marshaller marshaller) {
        System.out.println("After Marshaller Callback");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", hobbies=" + hobbies +
                '}';
    }
}
