package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OrderPrinting {


    private final Semaphore second = new Semaphore(0);
    private final Semaphore third = new Semaphore(0);

    public void printFirst() {
        System.out.println("First");
        second.release(1);
    }

    public void printSecond() throws InterruptedException {
        second.acquire();
        System.out.println("Second");
        third.release(1);
    }

    public void printThird() throws InterruptedException {
        third.acquire();
        System.out.println("Third");
    }

    public void orderPrinting() throws InterruptedException {
        final Thread t1 = new Thread(this::printFirst);

        final Thread t2 = new Thread(() -> {
            try {
                printSecond();
            } catch (InterruptedException ignored) {
            }
        });

        final Thread t3 = new Thread(() -> {
            try {
                printThird();
            } catch (InterruptedException ignored) {
            }
        });

        t3.start();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
