package com.avi.educative.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxHeapTest {

    @Test
    public void heapArray() {
        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
        final MaxHeap heap = new MaxHeap(heapArray);
        System.out.println("After heapify: "+Arrays.toString(heapArray));
    }

    @Test
    public void heapInsert() {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.poll());

        System.out.println("The max val is " + maxHeap.peek());
        System.out.println("Delete 0 " + maxHeap.delete(0));
        System.out.println("New Max " + maxHeap.peek());

        maxHeap.print();
        System.out.println("Delete 2 " + maxHeap.delete(2));
        maxHeap.print();
    }

    @Test
    public void kLargest() {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        final Heap heap = new MaxHeap(input);
        final int k = 2;
        for(int i = 0; i < k; i++){
            System.out.println(heap.poll());
        }
    }
}