package com.avi.educative.multithreading;

import org.junit.Test;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DiningPhilosophersTest {

    @Test
    public void test() throws InterruptedException {
        final DiningPhilosophers dp = new DiningPhilosophers(5);

        Thread p1 = new Thread(() -> startPhilosopher(dp, 0));

        Thread p2 = new Thread(() -> startPhilosopher(dp, 1));

        Thread p3 = new Thread(() -> startPhilosopher(dp, 2));

        Thread p4 = new Thread(() -> startPhilosopher(dp, 3));

        Thread p5 = new Thread(() -> startPhilosopher(dp, 4));

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
    }

    void startPhilosopher(DiningPhilosophers dp, int id) {
        try {
            dp.lifecycle(id);
        } catch (InterruptedException ie) {

        }
    }
}