package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MissedSignalsCorrect {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        final Thread signaller = new Thread(() -> {
            semaphore.release();
            System.out.println("Signal Sent");
        });


        final Thread waiter = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Signal Received");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        signaller.start();
        signaller.join();

        waiter.start();
        waiter.join();


    }
}
