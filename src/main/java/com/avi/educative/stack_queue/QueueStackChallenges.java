package com.avi.educative.stack_queue;

/**
 * Created by navinash on 04/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class QueueStackChallenges {

    public void reverseFirstK(final Queue<Integer> q, final int k) {

        final Stack<Integer> s = new Stack<>(k);
        while (!s.isFull()) {
            s.push(q.dequeue());
        }

        while (!s.isEmpty()) {
            q.enqueue(s.pop());
        }

        for (int i = 0; i < q.getMaxSize() - k; i++) {
            q.enqueue(q.dequeue());
        }
    }
}
