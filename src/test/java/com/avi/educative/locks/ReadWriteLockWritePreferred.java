package com.avi.educative.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReadWriteLockWritePreferred implements IReadWriteLock {

    private volatile boolean isWriteLocked = false;
    private volatile int readers = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition writeCondition = lock.newCondition();
    private Condition readCondition = lock.newCondition();

    @Override
    public void acquireReadLock() throws InterruptedException {
        lock.lock();
        while (isWriteLocked) {
            readCondition.await();
        }
        readers++;
        lock.unlock();
    }

    @Override
    public void releaseReadLock() {
        lock.lock();
        readers--;
        writeCondition.signal();
        lock.unlock();

    }

    @Override
    public void acquireWriteLock() throws InterruptedException {
        lock.lock();
        while (isWriteLocked || readers != 0) {
            writeCondition.await();
        }
        isWriteLocked = true;
        lock.unlock();
    }

    @Override
    public void releaseWriteLock() {
        lock.lock();
        isWriteLocked = false;
        writeCondition.signal();
        readCondition.signal();
        lock.unlock();
    }
}
