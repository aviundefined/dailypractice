package com.avi.educative.multithreading.blockingqueue;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BlockingQueueUsingSynchronized<T> implements IBlockingQueue<T> {

    private int size;
    private int head;
    private int tail;
    private int capacity;
    private final T[] arr;

    public BlockingQueueUsingSynchronized(final int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) (new Object[capacity]);
    }

    @Override
    public synchronized void enqueue(T data) throws InterruptedException {
        // If queue is full wait
        while (size == capacity) {
            this.wait();
        }

        // If tail is at end, move to at first position for next write
        if (tail == capacity) {
            tail = 0;
        }

        arr[tail] = data;
        size++;
        tail++;

        this.notifyAll();
    }

    @Override
    public synchronized T dequeue() throws InterruptedException {
        // if queue is empty wait
        while (size == 0) {
            this.wait();
        }

        // if reached at end of the queue then set the head to first position for next read
        if (head == capacity) {
            head = 0;
        }
        final T t = arr[head];
        size--;
        arr[head] = null;
        head++;
        this.notifyAll();
        return t;
    }

    @Override
    public synchronized int size() {
        return this.size;
    }
}

