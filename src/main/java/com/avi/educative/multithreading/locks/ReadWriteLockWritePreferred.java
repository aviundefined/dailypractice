package com.avi.educative.multithreading.locks;

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
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition writeCondition = lock.newCondition();
    private final Condition readCondition = lock.newCondition();
    private final ReentrantLock writerWaitingLock = new ReentrantLock();
    private volatile int numWritersWaiting = 0;

    @Override
    public void acquireReadLock() throws InterruptedException {
        lock.lock();
        while (isWriteLocked || numWritersWaiting > 0) {
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
        readCondition.signal();
        lock.unlock();

    }

    @Override
    public void acquireWriteLock() throws InterruptedException {
        writerWaitingLock.lock();
        numWritersWaiting++;
        writerWaitingLock.unlock();
        lock.lock();
        while (isWriteLocked || readers != 0) {
            writeCondition.await();
        }
        writerWaitingLock.lock();
        numWritersWaiting--;
        writerWaitingLock.unlock();
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
