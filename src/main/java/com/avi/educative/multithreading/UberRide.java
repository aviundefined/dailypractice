package com.avi.educative.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UberRide {

    private final ReentrantLock lock = new ReentrantLock();
    // IMPORTANT: This is important to initialize this as 0 as all threads are blocked until release explicitly by someone
    private final Semaphore democratsWaiting = new Semaphore(0);
    private final Semaphore republicansWaiting = new Semaphore(0);
    private final CyclicBarrier barrier = new CyclicBarrier(4);
    int numDemocrats = 0;
    int numRepublicans = 0;

    public void seatDemocrat() throws InterruptedException, BrokenBarrierException {
        boolean shouldStartRide = false;
        lock.lock();
        numDemocrats++;
        if (numDemocrats == 4) {
            democratsWaiting.release(3);
            numDemocrats -= 4;
            shouldStartRide = true;
        } else if (numDemocrats == 2 && numRepublicans >= 2) {
            democratsWaiting.release(1);
            republicansWaiting.release(2);
            numDemocrats -= 2;
            numRepublicans -= 2;
            shouldStartRide = true;
        } else {
            lock.unlock();
            democratsWaiting.acquire();
        }
        seated();
        barrier.await();
        if (shouldStartRide) {
            drive();
            lock.unlock();
        }
    }

    public void seatRepublican() throws InterruptedException, BrokenBarrierException {
        boolean shouldStartRide = false;
        lock.lock();
        numRepublicans++;
        if (numRepublicans == 4) {
            republicansWaiting.release(3);
            numRepublicans -= 4;
            shouldStartRide = true;
        } else if (numRepublicans == 2 && numDemocrats >= 2) {
            democratsWaiting.release(2);
            republicansWaiting.release(1);
            numDemocrats -= 2;
            numRepublicans -= 2;
            shouldStartRide = true;
        } else {
            lock.unlock();
            republicansWaiting.acquire();
        }
        seated();
        barrier.await();
        if (shouldStartRide) {
            drive();
            lock.unlock();
        }
    }

    private void seated() {
        System.out.println("Passenger Seated: " + Thread.currentThread().getName());
    }

    private void drive() {
        System.out.println("Uber Ride started by the ride leader: " + Thread.currentThread().getName());
        System.out.flush();
    }
}
