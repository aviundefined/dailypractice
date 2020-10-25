package com.avi.educative.locks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReadWriteLockTest {

    @Test
    public void test() throws Exception {

        final IReadWriteLock rwl = new ReadWriteLock();

        Thread t1 = new Thread(() -> {
            try {

                System.out.println("Attempting to acquire write lock in t1: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired t1: " + +System.currentTimeMillis());

                rwl.releaseWriteLock();

            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {

                System.out.println("Attempting to acquire write lock in t2: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired t2: " + System.currentTimeMillis());
                rwl.releaseWriteLock();
            } catch (InterruptedException ie) {

            }
        });

        Thread tReader1 = new Thread(() -> {
            try {

                rwl.acquireReadLock();
                System.out.println("Read lock acquired: " + System.currentTimeMillis());

            } catch (InterruptedException ie) {

            }
        });

        Thread tReader2 = new Thread(() -> {
            System.out.println("Read lock about to release: " + System.currentTimeMillis());
            rwl.releaseReadLock();
            System.out.println("Read lock released: " + System.currentTimeMillis());
        });

        tReader1.start();
        t1.start();
        Thread.sleep(3000);
        tReader2.start();
        Thread.sleep(1000);
        t2.start();
        tReader1.join();
        tReader2.join();
        t2.join();
    }

    @Test
    public void testWritePreferred() throws Exception {

        final IReadWriteLock rwl = new ReadWriteLockWritePreferred();

        Thread t1 = new Thread(() -> {
            try {

                System.out.println("Attempting to acquire write lock in t1: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired t1: " + +System.currentTimeMillis());

                rwl.releaseWriteLock();

            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {

                System.out.println("Attempting to acquire write lock in t2: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired t2: " + System.currentTimeMillis());
                rwl.releaseWriteLock();
            } catch (InterruptedException ie) {

            }
        });

        Thread tReader1 = new Thread(() -> {
            try {

                rwl.acquireReadLock();
                System.out.println("Read lock acquired: " + System.currentTimeMillis());

            } catch (InterruptedException ie) {

            }
        });

        Thread tReader2 = new Thread(() -> {
            System.out.println("Read lock about to release: " + System.currentTimeMillis());
            rwl.releaseReadLock();
            System.out.println("Read lock released: " + System.currentTimeMillis());
        });

        tReader1.start();
        t1.start();
        Thread.sleep(3000);
        tReader2.start();
        Thread.sleep(1000);
        t2.start();
        tReader1.join();
        tReader2.join();
        t2.join();
    }
}