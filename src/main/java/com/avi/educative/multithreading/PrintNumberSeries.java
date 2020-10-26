package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Created by navinash on 26/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PrintNumberSeries {

    private final int n;
    private final Semaphore zero = new Semaphore(1);
    private final Semaphore odd = new Semaphore(0);
    private final Semaphore even = new Semaphore(0);

    public PrintNumberSeries(int n) {
        this.n = n;
    }

    public void printZero() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            System.out.print(0);
            if (i % 2 == 0) {
                odd.release(1);
            } else {
                even.release(1);
            }
        }
    }

    public void printOdd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            System.out.print(i);
            zero.release();
        }
    }

    public void printEven() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            System.out.print(i);
            zero.release();
        }
    }
}
