package com.avi.educative.multithreading.revision;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 21/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BlockingQueueUsingLock<T> {

    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private final int capacity;
    private final T[] arr;
    private final Lock lock = new ReentrantLock();

    public BlockingQueueUsingLock(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
    }

    public final void enqueue(final T t) throws InterruptedException {
        lock.lock();
        while (this.size == this.capacity) {
            lock.unlock();
            lock.lock();
        }

        if (this.tail == this.capacity) {
            this.tail = 0;
        }
        this.arr[this.tail] = t;
        this.tail++;
        this.size++;
        lock.unlock();
    }

    public final T dequeue() throws InterruptedException {
        while (this.size == 0) {
            lock.unlock();
            lock.lock();
        }
        if (this.head == this.capacity) {
            this.head = 0;
        }
        final T t = this.arr[this.head];
        this.size--;
        this.head++;
        lock.unlock();
        return t;
    }
}
