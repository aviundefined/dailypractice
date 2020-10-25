package com.avi.educative.multithreading.semaphore;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountingSemaphoreTest {

    @Test
    public void pingPong() throws Exception {
        final CountingSemaphore cs = new CountingSemaphore(1);

        final Thread acquirer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    cs.acquire();
                    System.out.println("Ping: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        final Thread releaser = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    cs.release();
                    System.out.println("Pong: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        acquirer.start();
        releaser.start();

        acquirer.join();
        releaser.join();
    }

}