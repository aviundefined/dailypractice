package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by navinash on 27/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EvenOddSemaphore {

    private final Semaphore odd = new Semaphore(1);
    private final Semaphore even = new Semaphore(0);

    private final int n;

    public EvenOddSemaphore(final int n) {
        this.n = n;
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            System.out.println(i);
            even.release(1);
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            System.out.println(i);
            odd.release(1);
        }
    }
}
