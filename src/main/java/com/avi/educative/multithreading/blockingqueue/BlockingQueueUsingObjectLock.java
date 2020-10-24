package com.avi.educative.multithreading.blockingqueue;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BlockingQueueUsingObjectLock<T> implements IBlockingQueue<T> {

    private int size;
    private int head;
    private int tail;
    private int capacity;
    private final T[] arr;
    private Object lock = new Object();

    public BlockingQueueUsingObjectLock(final int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) (new Object[capacity]);
    }

    @Override
    public void enqueue(T data) throws InterruptedException {
        synchronized (lock) {
            // If queue is full wait
            while (size == capacity) {
                lock.wait();
            }

            // If tail is at end, move to at first position for next write
            if (tail == capacity) {
                tail = 0;
            }

            arr[tail] = data;
            size++;
            tail++;

            lock.notifyAll();
        }
    }

    @Override
    public synchronized T dequeue() throws InterruptedException {
        synchronized (lock) {
            // if queue is empty wait
            while (size == 0) {
                lock.wait();
            }

            // if reached at end of the queue then set the head to first position for next read
            if (head == capacity) {
                head = 0;
            }
            final T t = arr[head];
            size--;
            arr[head] = null;
            head++;
            lock.notifyAll();
            return t;
        }
    }

    @Override
    public synchronized int size() {
        return this.size;
    }
}
