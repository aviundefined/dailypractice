package com.avi.educative.multithreading.semaphore;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class CountingSemaphore {

    private final int maxPermits;
    private int usedPermits;

    public CountingSemaphore(final int maxPermits) {
        this.maxPermits = maxPermits;
    }

    public CountingSemaphore(final int maxPermits, final int initialPermits) {
        this.maxPermits = maxPermits;
        this.usedPermits = maxPermits - initialPermits;
    }

    public final synchronized void acquire() throws InterruptedException {
        while (usedPermits == maxPermits) {
            this.wait();
        }

        usedPermits++;
        notify();
    }

    public final synchronized void release() throws InterruptedException {
        while (usedPermits == 0) {
            this.wait();
        }
        usedPermits--;
        notify();
    }
}
