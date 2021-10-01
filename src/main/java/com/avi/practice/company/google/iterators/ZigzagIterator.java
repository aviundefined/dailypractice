package com.avi.practice.company.google.iterators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Created by navinash on 01/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ZigzagIterator {

    private final Queue<Iterator<Integer>> q = new ArrayDeque<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1 != null && v1.size() > 0) {
            q.offer(v1.iterator());
        }
        if (v2 != null && v2.size() > 0) {
            q.offer(v2.iterator());
        }
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public Integer next() {
        if (!hasNext()) {
            return null;
        }

        final Iterator<Integer> curr = q.poll();
        final int val = curr.next();
        if (curr.hasNext()) {
            q.offer(curr);
        }
        return val;
    }
}
