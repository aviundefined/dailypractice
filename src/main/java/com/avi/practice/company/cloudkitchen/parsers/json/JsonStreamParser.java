package com.avi.practice.company.cloudkitchen.parsers.json;

import com.avi.practice.company.cloudkitchen.parsers.model.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 31/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JsonStreamParser {

    private final Gson gson;

    public JsonStreamParser() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public final <T>  List<T> readJsonStream(InputStream in, final Class<T> clazz) throws IOException {
        final JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        final List<T> objs = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            T message = gson.fromJson(reader, clazz);
            objs.add(message);
        }
        reader.endArray();
        reader.close();
        return objs;
    }

    public final <T> void writeJsonStream(OutputStream out, List<T> objs, final Class<T> clazz) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writer.beginArray();
        for (T message : objs) {
            gson.toJson(message, clazz, writer);
        }
        writer.endArray();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        final JsonStreamParser parser = new JsonStreamParser();
        final InputStream is = new BufferedInputStream(new FileInputStream(new File("/Users/navinash/repos/dailypractice/src/main/resources/orders.json")));
        final List<Order> orders = parser.readJsonStream(is, Order.class);
        for(final Order order : orders) {
            System.out.println(order);
        }

        final String outputFile = "/Users/navinash/repos/dailypractice/src/main/resources/new-orders.json";
        final OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(outputFile)));
        parser.writeJsonStream(os, orders, Order.class);


    }
}
