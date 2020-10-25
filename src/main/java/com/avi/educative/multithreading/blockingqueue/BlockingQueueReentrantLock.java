package com.avi.educative.multithreading.blockingqueue;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BlockingQueueReentrantLock<T> implements IBlockingQueue<T> {

    private int size;
    private int head;
    private int tail;
    private final int capacity;
    private final T[] arr;
    private ReentrantLock lock = new ReentrantLock();

    public BlockingQueueReentrantLock(final int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) (new Object[capacity]);
    }

    @Override
    public void enqueue(T data) throws InterruptedException {
        lock.lock();
        while (size == capacity) {
            lock.unlock();
            lock.lock();
        }

        if (tail == capacity) {
            tail = 0;
        }

        arr[tail] = data;
        tail++;
        size++;
        lock.unlock();
    }

    @Override
    public T dequeue() throws InterruptedException {
        lock.lock();
        while (size == 0) {
            lock.unlock();
            lock.lock();
        }
        if (head == capacity) {
            head = 0;
        }
        final T t = arr[head];
        arr[head] = null;
        head++;
        size--;

        lock.unlock();
        return t;
    }

    @Override
    public int size() {
        return this.size;
    }
}
