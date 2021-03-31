package com.avi.practice.company.cloudkitchen.parsers.json;

import com.avi.practice.company.cloudkitchen.parsers.model.User;
import com.avi.practice.company.cloudkitchen.parsers.model.Department;
import com.avi.practice.company.cloudkitchen.parsers.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 31/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JSONParserExamples {

    public static void main(String[] args) {
        objToJson();
        jsonArrayToObjectsArray();
        jsonArrayToObjectsList();
        memberArrayExample();
    }

    private static void objToJson() {
        final Employee employee = new Employee(
                1001,
                "Lokesh",
                "Gupta",
                new Department(1, "Engineering"));
        final Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        final String json = gson.toJson(employee);
        System.out.println(json);
        System.out.println("----------------------");
    }

    private static void jsonArrayToObjectsArray() {
        final String userJson = "[{'name': 'Alex','id': 1}, "
                + "{'name': 'Brian','id':2}, "
                + "{'name': 'Charles','id': 3}]";
        final Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        final User[] users = gson.fromJson(userJson, User[].class);
        for (final User user : users) {
            System.out.println(user);
        }
        System.out.println("----------------------");
    }

    private static void jsonArrayToObjectsList() {
        final String userJson = "[{'name': 'Alex','id': 1}, "
                + "{'name': 'Brian','id':2}, "
                + "{'name': 'Charles','id': 3}]";
        final Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        final Type userListType = new TypeToken<ArrayList<User>>() {
        }.getType();
        final List<User> users = gson.fromJson(userJson, userListType);
        for (final User user : users) {
            System.out.println(user);
        }
        System.out.println("----------------------");
    }

    private static void memberArrayExample() {
        final String departmentJson = "{'id' : 1, "
                + "'name': 'HR',"
                + "'users' : ["
                + "{'name': 'Alex','id': 1}, "
                + "{'name': 'Brian','id':2}, "
                + "{'name': 'Charles','id': 3}]}";
        final Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        final Company department = gson.fromJson(departmentJson, Company.class);
        System.out.println(department);
        System.out.println("----------------------");
    }
}
