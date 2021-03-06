package com.avi.educative.tree;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxHeap extends Heap {

    public MaxHeap(int n) {
        super(n);
    }

    public MaxHeap(int[] arr) {
        super(arr);
    }

    @Override
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

    @Override
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

    protected final void heapifyHelper(int index, int heapSize) {
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

}
