package com.avi.educative.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MissedSignals {

    public static void main(String[] args) throws InterruptedException {
        correctMissedSignalsUsingSemaphore();
    }

    private static void correctMissedSignalsUsingMonitor() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        AtomicBoolean flag = new AtomicBoolean(false);
        final Thread signaller = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                condition.signal();
                flag.set(true);
                System.out.println("Signal Sent");
                lock.unlock();
            }
        });


        final Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                while (!flag.get()) {
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Signal Received");
            lock.unlock();
        });


        waiter.start();
        signaller.start();

        waiter.join();
        signaller.join();
    }

    private static void correctMissedSignalsUsingSemaphore() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        final Thread signaller = new Thread(() -> {
            System.out.println("Going to sent signal");
            semaphore.release();
            System.out.println("Signal Sent");
        });


        final Thread waiter = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Signal Received");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        signaller.start();
        signaller.join();

        waiter.start();
        waiter.join();

    }

    private static void incorrectMissedSignals() throws Exception {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        final Thread signaller = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                condition.signal();
                System.out.println("Signal Sent");
                lock.unlock();
            }
        });


        final Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Signal Received");
            lock.unlock();
        });


        signaller.start();
        signaller.join();

        waiter.start();
        waiter.join();
    }
}
