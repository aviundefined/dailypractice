package com.avi.educative.multithreading.revision;

/**
 * Created by navinash on 21/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class BlockingQueueUsingSynchronized<T> {

    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private final int capacity;
    private final T[] arr;

    public BlockingQueueUsingSynchronized(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[this.capacity];
    }

    public final synchronized void enqueue(final T t) throws InterruptedException {
        while (this.size == this.capacity) {
            wait();
        }

        if (this.tail == this.capacity) {
            this.tail = 0;
        }
        this.arr[this.tail] = t;
        this.tail++;
        this.size++;
        notifyAll();
    }

    public final synchronized T dequeue() throws InterruptedException {
        while (this.size == 0) {
            wait();
        }
        if (this.head == this.capacity) {
            this.head = 0;
        }
        final T t = this.arr[this.head];
        this.size--;
        this.head++;
        notifyAll();
        return t;
    }

}
