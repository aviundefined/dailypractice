package com.avi.educative.stack_queue;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Stack<T> {

    private final int maxSize;
    private T[] arr;
    private int top = -1;
    private int currentSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = (T[]) new Object[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(final T data) {
        if (isFull()) {
            throw new RuntimeException("Stack is full. Max Size: " + maxSize);
        }
        top++;
        currentSize++;
        arr[top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        final T data = arr[top];
        arr[top] = null;
        top--;
        currentSize--;
        return data;
    }

    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return arr[top];
    }

    public int getCurrentSize() {
        return this.currentSize;
    }
}
