package com.avi.paradigms.greedy;

import com.avi.practice.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class IntervalScheduling {

    private final List<Interval> intervals = new ArrayList<>();
    private final int n;

    IntervalScheduling(final List<Interval> intervals) {
        if (!CommonUtils.isEmpty(intervals)) {
            this.intervals.addAll(intervals);
        }
        this.n = this.intervals.size();
    }

    final List<Interval> maxIntervals() {
        if (CommonUtils.isEmpty(intervals)) {
            return Collections.emptyList();
        }
        final Stack<Interval> stack = new Stack<>();
        // Sort on earliest end time
        this.intervals.sort(Comparator.comparingInt(o -> o.end));
        // choose base on earliest start time
        stack.add(this.intervals.get(0));
        int curIdx = 1;
        while (curIdx < n && !stack.isEmpty()) {
            final Interval lastJob = stack.peek();
            final Interval currJob = this.intervals.get(curIdx);
            if (currJob.start >= lastJob.end) {
                stack.add(currJob);
            }
            curIdx++;
        }
        final List<Interval> result = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        return result;
    }

    final static class Interval {
        private final int start;
        private final int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start &&
                    end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
