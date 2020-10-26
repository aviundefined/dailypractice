package com.avi.educative.multithreading;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BarberShopTest {

    @Test
    public void test() throws Exception {
        final Set<Thread> set = new HashSet<Thread>();
        final BarberShop barberShopProblem = new BarberShop(3);

        Thread barberThread = new Thread(() -> {
            try {
                barberShopProblem.barber();
            } catch (InterruptedException ie) {

            }
        });
        barberThread.setName("Barber");
        barberThread.start();

        for (int i = 0; i < 10; i++) {
            final String name = "Customer-" + i;
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customer();
                } catch (InterruptedException ie) {

                }
            });
            t.setName(name);
            set.add(t);
        }

        for (Thread t : set) {
            t.start();
        }

        for (Thread t : set) {
            t.join();
        }

        set.clear();
        Thread.sleep(800);

        for (int i = 0; i < 5; i++) {
            final String name = "Customer-" + i;
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customer();
                } catch (InterruptedException ie) {

                }
            });
            t.setName(name);
            set.add(t);
        }
        for (Thread t : set) {
            t.start();
        }

        barberThread.join();
    }


    @Test
    public void basic() throws Exception {
        final int numSeats = 5;
        final BarberShop barberShop = new BarberShop(numSeats);
        final Thread barberThread = new Thread(() -> {
            try {
                barberShop.barber();
            } catch (InterruptedException ignored) {

            }
        });
        barberThread.setName("Barber");
        barberThread.start();

        sendCustomers(barberShop, 10);
        Thread.sleep(1000);
        sendCustomers(barberShop, 10);
        barberThread.join();
    }

    private void sendCustomers(BarberShop barberShop, int numCustomers) {
        final Thread[] customers = new Thread[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            final String name = "Customer-" + i;
            final Thread customer = new Thread(() -> {
                try {
                    barberShop.customer();
                } catch (InterruptedException ignored) {

                }
            });
            customer.setName(name);
            customers[i] = customer;
        }

        for (final Thread customer : customers) {
            customer.start();
        }
    }
}