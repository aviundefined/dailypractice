package com.avi.educative.stack_queue;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinStack {

    private final Stack<Integer> s;
    private final Stack<Integer> min;
    private final int maxSize;
    private int currSize;

    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        s = new Stack<>(maxSize);
        min = new Stack<>(maxSize);
    }


    public void push(Integer data) {
        if (s.isFull()) {
            throw new RuntimeException("Stack is full. Max Size: " + maxSize);
        }

        s.push(data);
        if (min.isEmpty() || min.top() >= data) {
            min.push(data);
        }
    }

    public Integer pop() {
        if (s.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        final Integer top = s.pop();
        if (top <= min.top()) {
            min.pop();
        }
        return top;
    }

    public Integer min() {
        return min.top();
    }

}
