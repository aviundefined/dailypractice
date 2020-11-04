package com.avi.educative.stack_queue;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueueWithStack<T> {

    private final int maxSize;
    private final Stack<T> s1;
    private final Stack<T> s2;
    private int currentSize = 0;

    public QueueWithStack(int maxSize) {
        this.maxSize = maxSize;
        this.s1 = new Stack<>(maxSize);
        this.s2 = new Stack<>(maxSize);
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(final T data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full. Max size: " + maxSize);
        }
        currentSize++;
        s1.push(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
