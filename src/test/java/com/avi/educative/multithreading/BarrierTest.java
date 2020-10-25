package com.avi.educative.multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BarrierTest {

    @Test
    public void test() throws InterruptedException {
        final Barrier barrier = new Barrier(3);

        Thread p1 = new Thread(() -> {
            try {
                barrier.await();
                barrier.await();
                barrier.await();
            } catch (InterruptedException ie) {
            }
        });

        Thread p2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                barrier.await();
                Thread.sleep(500);
                barrier.await();
                Thread.sleep(500);
                barrier.await();
            } catch (InterruptedException ie) {
            }
        });

        Thread p3 = new Thread(() -> {
            try {
                Thread.sleep(1500);
                barrier.await();
                Thread.sleep(1500);
                barrier.await();
                Thread.sleep(1500);
                barrier.await();
            } catch (InterruptedException ie) {
            }
        });

        p1.start();
        p2.start();
        p3.start();

        p1.join();
        p2.join();
        p3.join();
    }

}