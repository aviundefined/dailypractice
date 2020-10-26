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

    private volatile int numWaitingCustomers;
    private final ReentrantLock lock = new ReentrantLock();
    private final Semaphore barberWaitingForCustomer = new Semaphore(0);
    private final Semaphore barberCuttingHair = new Semaphore(0);

    public BarberShop(final int maxWaitingSeats) {
        this.maxWaitingSeats = maxWaitingSeats;
    }

    public void customer() throws InterruptedException {
        lock.lock();
        if (numWaitingCustomers == maxWaitingSeats) {
            System.out.println("No waiting charis available. Customer is going back");
            lock.unlock();
            return;
        }
        numWaitingCustomers++;
        lock.unlock();

        barberWaitingForCustomer.release();

        barberCuttingHair.acquire();

        lock.lock();
        numWaitingCustomers--;
        lock.unlock();
    }

    public void barber() throws InterruptedException {
        while (true) {
            barberWaitingForCustomer.acquire();

            System.out.println("Barber cutting hair");

            Thread.sleep(HAIR_CUT_TIME_MS);

            barberCuttingHair.release();
        }
    }
}
