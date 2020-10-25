package com.avi.educative.multithreading;

/**
 * Created by navinash on 25/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Barrier {

    private final int maxAllowed;
    private volatile int count = 0;
    private volatile int released = 0;

    public Barrier(int maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public synchronized void await() throws InterruptedException {
        // IMPORTANT: This is added so that same barrier object can be reused.
        // Consider a case when all threads are reached to barrier and released then after that if any new
        // thread is calling await then it has to wait until count has become 0, that means all threads have been released
        while (count == maxAllowed) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " entered the barrier");
        // New thread reached to the barrier
        count++;
        // if all have reached then notify all to move forward
        if (count == maxAllowed) {
            notifyAll();
            // set this variable to max allowed and later on it will be decrement 1 by 1 by each thread
            // when they exit this method
            released = maxAllowed;
        } else {
            // If all threads are not reached then just simply wait
            while (count < maxAllowed) {
                wait();
            }
        }
        System.out.println(Thread.currentThread().getName() + " exited the barrier");
        // Decrement this one by one, once this is 0 then mark count 0 as all threads are exited the barrier
        released--;
        if (released == 0) {
            count = 0;
            // IMPORTANT: Notify all the new threads which have reused this same barrier
            notifyAll();
        }
    }
}
