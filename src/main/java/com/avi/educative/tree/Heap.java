package com.avi.educative.tree;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public abstract class Heap implements IHeap {

    protected final int n;
    protected final int[] arr;
    protected int currentSize = 0;
    protected int lastIndex = -1;

    public Heap(int n) {
        this.n = n;
        this.arr = new int[n];
    }

    public Heap(int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        build();
    }

    @Override
    public final int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        final int element = arr[0];
        delete(0);
        return element;
    }

    @Override
    public final int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return arr[0];
    }

    private void build() {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapifyHelper(i, n);
        }
        this.currentSize = n;
    }

    protected final void heapify(int index) {
        heapifyHelper(index, currentSize);
    }

    protected final boolean isEmpty() {
        return currentSize == 0;
    }

    protected final boolean isFull() {
        return currentSize == n;
    }

    @Override
    public final void print() {
        final int lastParent = lastIndex / 2;
        for (int i = 0; i <= lastParent; i++) {
            System.out.print(" PARENT : " + arr[i] + " LEFT CHILD : " +
                    arr[leftChildIndex(i)] + " RIGHT CHILD :" + arr[rightChildIndex(i)]);
            System.out.println();
        }
    }

    protected final int parentIndex(final int index) {
        if (index % 2 == 0) {
            return (index - 1) / 2;
        }
        return index / 2;
    }

    protected final int leftChildIndex(final int parent) {
        return (2 * parent) + 1;
    }

    protected final int rightChildIndex(final int parent) {
        return (2 * parent) + 2;
    }

    protected final void swap(int firstIndex, int secondIndex) {
        final int tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }

    protected abstract void heapifyHelper(int index, int currentSize);

}
