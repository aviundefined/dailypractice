package com.avi.educative.tree;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxHeap {

    private final int n;
    private final int[] arr;
    private int currentSize = 0;
    private int lastIndex = -1;

    public MaxHeap(int n) {
        this.n = n;
        this.arr = new int[n];
    }

    public MaxHeap(int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        build();
    }

    public void insert(final int num) {
        if (isFull()) {
            throw new RuntimeException("Heal is full. Max size: " + n);
        }
        // Increment size
        currentSize++;
        lastIndex++;
        // insert value at end
        arr[lastIndex] = num;
        int current = lastIndex;
        while (arr[current] > arr[parentIndex(current)]) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    public int delete(final int index) {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        if (index < 0) {
            throw new RuntimeException("Index can't be less than 0. Index: " + index);
        }
        if (index >= currentSize) {
            throw new RuntimeException(String.format("Index [%d] should be less than current size [%d] of heap", index, currentSize));
        }
        final int deleted = arr[index];
        arr[index] = arr[lastIndex];
        arr[lastIndex] = Integer.MIN_VALUE;
        currentSize--;
        lastIndex--;
        heapify(index);
        return deleted;
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        final int max = arr[0];
        delete(0);
        return max;
    }

    public int getMax() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return arr[0];
    }

    public void print() {
        final int lastParent = lastIndex / 2;
        for (int i = 0; i <= lastParent; i++) {
            System.out.print(" PARENT : " + arr[i] + " LEFT CHILD : " +
                    arr[leftChildIndex(i)] + " RIGHT CHILD :" + arr[rightChildIndex(i)]);
            System.out.println();
        }
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private boolean isFull() {
        return currentSize == n;
    }

    private void build() {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            _heapify(i, n);
        }
        this.currentSize = n;
    }

    private void heapify(int index) {
        _heapify(index, currentSize);
    }

    private void _heapify(int index, int heapSize) {
        int largest = index;
        while (largest < heapSize / 2) {
            final int left = leftChildIndex(index);
            final int right = rightChildIndex(index);
            if (left < heapSize && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        final int tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }

    private int parentIndex(final int index) {
        if (index % 2 == 0) {
            return (index - 1) / 2;
        }
        return index / 2;
    }

    private int leftChildIndex(final int parent) {
        return (2 * parent) + 1;
    }

    private int rightChildIndex(final int parent) {
        return (2 * parent) + 2;
    }
}
