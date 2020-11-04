package com.avi.educative.stack_queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueueStackChallengesTest {

    private final QueueStackChallenges solver = new QueueStackChallenges();
    @Test
    public void reverseFirstK() {

        final Queue<Integer> queue = new Queue<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        solver.reverseFirstK(queue,5);

        System.out.print("Queue: ");
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}