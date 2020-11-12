package com.avi.educative.tree;

import org.junit.Test;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinHeapTest {


    @Test
    public void heapArray() {
        {
            int[] heapArray = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
            final Heap heap = new MinHeap(heapArray);
            heap.print();
        }
        {
            int[] heapArray = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
            final Heap heap = new MinHeap(heapArray.length);
            for (final int a : heapArray) {
                heap.insert(a);
            }
            //  heap.print();
        }
    }


    @Test
    public void heapInsert() {
        System.out.println("The Min Heap is ");
        Heap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();
        System.out.println("The min val is " + minHeap.poll());

        System.out.println("The min val is " + minHeap.peek());
        System.out.println("Delete 0 " + minHeap.delete(0));
        System.out.println("New min " + minHeap.peek());

        minHeap.print();
        System.out.println("Delete 2 " + minHeap.delete(2));
        minHeap.print();
    }

    @Test
    public void kSmallest() {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        final Heap heap = new MinHeap(input);
        final int k = 2;
        for (int i = 0; i < k; i++) {
            System.out.println(heap.poll());
        }
    }
}
