package com.avi.educative.multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TokenBucketFilterTest {

    @Test
    public void test() throws InterruptedException {
        final TokenBucketFilter filter = new TokenBucketFilter(5);
        Thread.sleep(3000L);
        final Thread[] consumers = new Thread[10];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(() -> {
                try {
                    filter.getToken();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (Thread consumer : consumers) {
            consumer.start();
        }
        for (Thread consumer : consumers) {
            consumer.join();
        }
    }
}