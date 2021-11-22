package com.avi.educative.multithreading.revision;

/**
 * Created by navinash on 22/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class CountingSemaphore implements ISemaphore {
    private final int maxPermits;
    private int usedPermits = 0;

    public CountingSemaphore(int maxPermits) {
        this.maxPermits = maxPermits;
    }

    @Override
    public final synchronized void acquire() throws InterruptedException {
        while (this.usedPermits == this.maxPermits) {
            this.wait();
        }
        this.usedPermits++;
        notify();
    }

    @Override
    public final synchronized void release() throws InterruptedException {
        while (this.usedPermits == 0) {
            this.wait();
        }
        this.usedPermits--;
        notify();
    }
}
