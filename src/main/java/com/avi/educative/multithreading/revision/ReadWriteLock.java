package com.avi.educative.multithreading.revision;

/**
 * Problem Statement
 * Imagine you have an application where you have multiple readers and multiple writers.
 * You are asked to design a lock which lets multiple readers read at the same time, but only one writer write at a time.
 */
public class ReadWriteLock implements IReadWriteLock {


    private boolean isWriting = false;
    private int readers = 0;

    @Override
    public synchronized void acquireReadLock() throws InterruptedException {
        while (isWriting) {
            wait();
        }
        readers++;
    }

    @Override
    public synchronized void releaseReadLock() {
        readers--;
        notifyAll();
    }

    @Override
    public synchronized void acquireWriteLock() throws InterruptedException {
        while (isWriting || readers != 0) {
            wait();
        }
        isWriting = true;
    }

    @Override
    public synchronized void releaseWriteLock() {
        isWriting = false;
        notifyAll();
    }
}
