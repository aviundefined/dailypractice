package com.avi.educative.multithreading;

import org.junit.Test;

/**
 * Created by navinash on 28/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EvenOddTest {

    @Test
    public void testSemaphore() throws InterruptedException {
        final EvenOddSemaphore evenOdd = new EvenOddSemaphore(100);
        final Thread odd = new Thread(() -> {
            try {
                evenOdd.odd();
            } catch (InterruptedException ignored) {
            }
        });
        final Thread even = new Thread(() -> {
            try {
                evenOdd.even();
            } catch (InterruptedException ignored) {
            }
        });
        odd.start();
        even.start();
        odd.join();
        even.join();
    }

    @Test
    public void testLock() throws InterruptedException {
        final EvenOddLock evenOdd = new EvenOddLock(100);
        final Thread odd = new Thread(() -> {
            try {
                evenOdd.odd();
            } catch (InterruptedException ignored) {
            }
        });
        final Thread even = new Thread(() -> {
            try {
                evenOdd.even();
            } catch (InterruptedException ignored) {
            }
        });
        odd.start();
        even.start();
        odd.join();
        even.join();
    }
}