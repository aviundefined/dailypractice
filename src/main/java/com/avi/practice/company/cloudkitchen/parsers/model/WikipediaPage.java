package com.avi.practice.company.cloudkitchen.parsers.model;

/**
 * Created by navinash on 31/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WikipediaPage {
    private final String id;
    private final String name;
    public WikipediaPage(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "WikipediaPage{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
