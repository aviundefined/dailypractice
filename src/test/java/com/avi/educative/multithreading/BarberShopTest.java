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
        barberThread.start();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customer();
                } catch (InterruptedException ie) {

                }
            });
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
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customer();
                } catch (InterruptedException ie) {

                }
            });
            set.add(t);
        }
        for (Thread t : set) {
            t.start();
        }

        barberThread.join();
    }
}