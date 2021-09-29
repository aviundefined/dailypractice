package com.avi.practice.company.google;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by navinash on 29/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MergingIterator {

    private final List<Iterator<Integer>> iterators;
    private final PriorityQueue<IteratorIndex> pq;

    public MergingIterator(List<Iterator<Integer>> iterators) {
        this.iterators = iterators;
        pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for (int i = 0; i < iterators.size(); i++) {
            final Iterator<Integer> itr = iterators.get(i);
            if (itr.hasNext()) {
                pq.offer(new IteratorIndex(i, itr.next()));
            }
        }
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public Integer next() {
        if (!hasNext()) {
            throw new RuntimeException("No Element Exception");
        }

        final IteratorIndex curr = pq.poll();
        if (curr == null) {
            throw new RuntimeException("No Element Exception");
        }
        if (iterators.get(curr.itrIndex).hasNext()) {
            pq.offer(new IteratorIndex(curr.itrIndex, iterators.get(curr.itrIndex).next()));
        }
        return curr.value;
    }

    private static final class IteratorIndex {
        private final int itrIndex;
        private final int value;

        public IteratorIndex(int itrIndex, int value) {
            this.itrIndex = itrIndex;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + itrIndex + "," + value + "}";
        }
    }
}
