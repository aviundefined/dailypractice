package com.avi.educative.multithreading;

/**
 * Created by navinash on 28/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EvenOddLockObject {


    private final int n;
    private final Object lock = new Object();
    private volatile int curr = 1;

    public EvenOddLockObject(final int n) {
        this.n = n;
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (lock) {
                while (curr % 2 == 0) {
                    lock.wait();
                }
                System.out.println(i);
                curr++;
                lock.notify();
            }
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (lock) {
                while (curr % 2 != 0) {
                    lock.wait();
                }
                System.out.println(i);
                curr++;
                lock.notify();
            }
        }
    }
}
