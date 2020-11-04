package com.avi.educative.stack_queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueueTest {

    @Test
    public void testAll() {
        Queue<Integer> queue = new Queue<>(5);
        //equeue 2 4 6 8 10 at the end
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);
        //dequeue 2 elements from the start
        queue.dequeue();
        queue.dequeue();
        //enqueue 12 and 14 at the end
        queue.enqueue(12);
        queue.enqueue(14);

        System.out.println("Queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}