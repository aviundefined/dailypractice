package com.avi.educative.stack_queue;

/**
 * Created by navinash on 03/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TwoStacks<T> {

    private final int maxSize;
    private final T[] arr;
    private int top1;
    private int top2;

    public TwoStacks(final int maxSize) {
        this.maxSize = maxSize;
        //noinspection unchecked
        arr = (T[]) (new Object[maxSize]);
        top1 = -1;
        top2 = maxSize;
    }

    public void push1(final T data) {
        if (top1 < top2 - 1) {
            arr[++top1] = data;
        }
    }

    public void push2(final T data) {
        if (top1 < top2 - 1) {
            arr[--top2] = data;
        }
    }

    public T pop1() {
        if (top1 > -1) {
            return arr[top1--];
        }
        return null;
    }

    public T pop2() {
        if (top2 < maxSize) {
            return arr[top2++];
        }
        return null;
    }
}
