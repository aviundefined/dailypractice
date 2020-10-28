package com.avi.educative.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 28/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EvenOddReentrantLock {


    private final int n;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    private volatile int curr = 1;

    public EvenOddReentrantLock(final int n) {
        this.n = n;
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            while (curr % 2 == 0) {
                cond.await();
            }
            System.out.println(i);
            curr++;
            cond.signal();
            lock.unlock();
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            while (curr % 2 != 0) {
                cond.await();
            }
            System.out.println(i);
            curr++;
            cond.signal();
            lock.unlock();
        }
    }
}
