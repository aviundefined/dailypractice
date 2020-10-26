package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DiningPhilosophers {

    private final int numPhilosophers;
    private final Semaphore[] forks;
    private final Semaphore maxDiners;

    public DiningPhilosophers(final int numPhilosophers) {
        this.numPhilosophers = numPhilosophers;
        this.forks = new Semaphore[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }
        this.maxDiners = new Semaphore(numPhilosophers - 1);
    }

    public void lifecycle(final int id) throws InterruptedException {
        while (true) {
            contemplate();
            eat(id);
        }
    }

    private void eat(int id) throws InterruptedException {
        maxDiners.acquire();

        forks[id].acquire();
        forks[(id + 1) % numPhilosophers].acquire();

        System.out.println("philosopher [" + id + "] is eating");
        Thread.sleep(100);

        forks[id].release();
        forks[(id + 1) % numPhilosophers].release();

        maxDiners.release();
    }

    private void contemplate() throws InterruptedException {
        Thread.sleep(100);
    }
}
