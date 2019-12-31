package com.avi.learning.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by navinash on 27/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class SimpleProducer {

    public static void main(String[] args) throws Exception {

        final String topicName = "SimpleProducerTopicNew";
        final String key = "Key1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        //Enter data using BufferReader
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                // Reading data using readLine
                String value = reader.readLine();
                ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
                producer.send(record);
            }
        } finally {
            producer.close();
        }
    }
}

