package com.avi.educative.locks;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReadWriteLock implements IReadWriteLock{

    private volatile int readers = 0;
    private volatile boolean isWriteLocked = false;

    public synchronized final void acquireReadLock() throws InterruptedException {
        while (isWriteLocked) {
            wait();
        }
        readers++;
    }

    public synchronized final void releaseReadLock() {
        readers--;
        notify();
    }

    public synchronized final void acquireWriteLock() throws InterruptedException {
        while (isWriteLocked || readers != 0) {
            wait();
        }
        isWriteLocked = true;
    }

    public synchronized final void releaseWriteLock() {
        isWriteLocked = false;
        notify();
    }
}
