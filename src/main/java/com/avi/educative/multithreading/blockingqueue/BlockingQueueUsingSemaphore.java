package com.avi.educative.multithreading.blockingqueue;

import com.avi.educative.multithreading.semaphore.CountingSemaphore;

/**
 * Created by navinash on 24/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BlockingQueueUsingSemaphore<T> implements IBlockingQueue<T> {

    private int size;
    private int head;
    private int tail;
    private int capacity;
    private final T[] arr;
    private final CountingSemaphore lock = new CountingSemaphore(1, 1);
    private final CountingSemaphore producer;
    private final CountingSemaphore consumer;

    public BlockingQueueUsingSemaphore(final int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) (new Object[capacity]);
        this.producer = new CountingSemaphore(capacity, capacity);
        this.consumer = new CountingSemaphore(capacity, 0);
    }


    @Override
    public void enqueue(T data) throws InterruptedException {
        producer.acquire();
        lock.acquire();
        if (tail == capacity) {
            tail = 0;
        }
        arr[tail] = data;
        tail++;
        size++;
        lock.release();
        consumer.release();

    }

    @Override
    public T dequeue() throws InterruptedException {
        consumer.acquire();
        lock.acquire();

        if (head == capacity) {
            head = 0;
        }
        final T t = arr[head];
        arr[head] = null;
        head++;
        size--;
        lock.release();
        producer.release();
        return t;
    }

    @Override
    public int size() {
        return this.size;
    }
}
