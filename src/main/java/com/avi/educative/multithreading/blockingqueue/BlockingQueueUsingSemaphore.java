package com.avi.educative.multithreading.blockingqueue;

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


    public BlockingQueueUsingSemaphore(final int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) (new Object[capacity]);
    }


    @Override
    public void enqueue(T data) throws InterruptedException {

    }

    @Override
    public T dequeue() throws InterruptedException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
