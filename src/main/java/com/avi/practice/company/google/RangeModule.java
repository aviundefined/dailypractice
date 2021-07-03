package com.avi.practice.company.google;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by navinash on 02/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RangeModule {

    private final TreeSet<Range> ranges = new TreeSet<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        final Iterator<Range> itr = this.ranges.tailSet(new Range(0, left), true).iterator();
        while (itr.hasNext()) {
            final Range curr = itr.next();
            if (curr.left > right) {
                break;
            }
            left = Math.min(left, curr.left);
            right = Math.max(right, curr.right);
            itr.remove();
        }
        ranges.add(new Range(left, right));
    }

    public boolean queryRange(int left, int right) {
        final Range ceiling = this.ranges.ceiling(new Range(0, right));
        return ceiling != null && ceiling.left <= left;
    }

    public void removeRange(int left, int right) {
        final Iterator<Range> itr = this.ranges.tailSet(new Range(0, left), false).iterator();
        Range front = null;
        Range back = null;
        while (itr.hasNext()) {
            final Range curr = itr.next();
            if (curr.left >= right) {
                break;
            }
            if (curr.left < left) {
                front = new Range(curr.left, left);
            }
            if (curr.right > right) {
                back = new Range(right, curr.right);
            }
            itr.remove();
        }
        if (front != null) {
            ranges.add(front);
        }
        if (back != null) {
            ranges.add(back);
        }
    }

    private static final class Range implements Comparable<Range> {
        private final int left;
        private final int right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Range o) {
            if (this.right == o.right) {
                return this.left - o.left;
            }
            return this.right - o.right;
        }
    }
}
