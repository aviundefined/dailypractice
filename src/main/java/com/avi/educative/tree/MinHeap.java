package com.avi.educative.tree;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinHeap extends Heap {

    public MinHeap(int n) {
        super(n);
    }

    public MinHeap(int[] arr) {
        super(arr);
    }

    @Override
    protected void heapifyHelper(int index, int currentSize) {
        int smallest = index;
        while (index < (currentSize / 2)) {
            final int left = leftChildIndex(index);
            final int right = rightChildIndex(index);

            if (left < currentSize && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if (right < currentSize && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    @Override
    public void insert(final int num) {
        if (isFull()) {
            throw new RuntimeException("Heal is full. Max size: " + n);
        }
        currentSize++;
        lastIndex++;
        arr[lastIndex] = num;
        int current = lastIndex;
        while (arr[current] < arr[parentIndex(current)]) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    @Override
    public int delete(int index) {
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
        arr[lastIndex] = Integer.MAX_VALUE;
        currentSize--;
        lastIndex--;
        heapify(index);
        return deleted;
    }
}
