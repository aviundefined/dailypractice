package com.avi.educative.multithreading;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UberRideTest {

    @Test
    public void test() throws Exception {
        final UberRide uberSeatingProblem = new UberRide();
        Set<Thread> allThreads = new HashSet<>();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
                try {
                    uberSeatingProblem.seatDemocrat();
                } catch (InterruptedException | BrokenBarrierException ie) {
                    System.out.println("We have a problem");

                }

            });
            thread.setName("Democrat_" + (i + 1));
            allThreads.add(thread);

            Thread.sleep(50);
        }

        for (int i = 0; i < 14; i++) {
            Thread thread = new Thread(() -> {
                try {
                    uberSeatingProblem.seatRepublican();
                } catch (InterruptedException | BrokenBarrierException ie) {
                    System.out.println("We have a problem");

                }
            });
            thread.setName("Republican_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(20);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }
}