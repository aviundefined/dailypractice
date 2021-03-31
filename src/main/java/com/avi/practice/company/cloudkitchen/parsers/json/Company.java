package com.avi.practice.company.cloudkitchen.parsers.json;

import com.avi.practice.company.cloudkitchen.parsers.model.User;

import java.util.Arrays;

/**
 * Created by navinash on 31/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Company {

    private long id;
    private String name;
    private User[] users;

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", users=" + Arrays.toString(users) + "]";
    }
}
