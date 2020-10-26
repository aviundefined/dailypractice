package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BarberShop {

    private static final int HAIR_CUT_TIME_MS = 100;
    private final int maxWaitingSeats;

    private volatile int numWaitingCustomers = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private final Semaphore barberWaitingForCustomer = new Semaphore(0);
    private final Semaphore barberCuttingHair = new Semaphore(0);

    public BarberShop(final int maxWaitingSeats) {
        this.maxWaitingSeats = maxWaitingSeats;
    }

    public void customer() throws InterruptedException {
        lock.lock();
        if (numWaitingCustomers == maxWaitingSeats) {
            System.out.println("Customer is going back: " + Thread.currentThread().getName());
            lock.unlock();
            return;
        }
        System.out.println("Customer waiting: " + Thread.currentThread().getName());
        numWaitingCustomers++;
        lock.unlock();

        barberWaitingForCustomer.release();

        barberCuttingHair.acquire();
        System.out.println("Haircut done: " + Thread.currentThread().getName());
        lock.lock();
        numWaitingCustomers--;
        lock.unlock();
    }

    public void barber() throws InterruptedException {
        while (true) {
            barberWaitingForCustomer.acquire();
            Thread.sleep(HAIR_CUT_TIME_MS);
            barberCuttingHair.release();
        }
    }
}
