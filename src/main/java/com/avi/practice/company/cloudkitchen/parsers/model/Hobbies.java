package com.avi.practice.company.cloudkitchen.parsers.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by navinash on 27/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
@XmlRootElement(name = "hobbies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hobbies implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<String> hobby;

    public Hobbies() {
    }

    public Hobbies(List<String> hobby) {
        this.hobby = hobby;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Hobbies{" +
                "hobby=" + hobby +
                '}';
    }
}
