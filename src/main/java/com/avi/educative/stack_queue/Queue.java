package com.avi.educative.stack_queue;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Queue<T> {

    private final int maxSize;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;
    private final T[] arr;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = (T[]) new Object[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(final T data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full. Max size: " + maxSize);
        }
        tail = (tail + 1) % maxSize;
        arr[tail] = data;
        currentSize++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        final T data = arr[head];
        arr[head] = null;
        head = (head + 1) % maxSize;
        currentSize--;
        return data;
    }

    public T head() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[head];
    }
}
