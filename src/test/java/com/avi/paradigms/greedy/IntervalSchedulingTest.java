package com.avi.paradigms.greedy;

import com.avi.paradigms.greedy.IntervalScheduling.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class IntervalSchedulingTest {

    @Test
    public void maxIntervals() {
        final List<Interval> intervals = new ArrayList<>();
        intervals.add(interval(1,5));
        intervals.add(interval(2,4));
        intervals.add(interval(5,7));
        intervals.add(interval(8,9));
        intervals.add(interval(8,10));
        intervals.add(interval(11,12));
        final IntervalScheduling solver = new IntervalScheduling(intervals);
        final List<Interval> expected = new ArrayList<>();
        expected.add(interval(2,4));
        expected.add(interval(5,7));
        expected.add(interval(8,9));
        expected.add(interval(11,12));
        final List<Interval> maxIntervals = solver.maxIntervals();
        Assert.assertEquals(expected, maxIntervals);
    }

    private static Interval interval(final int start, final int end) {
        return new Interval(start, end);
    }

}
