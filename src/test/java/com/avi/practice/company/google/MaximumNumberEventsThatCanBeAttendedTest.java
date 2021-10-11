package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 08/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumNumberEventsThatCanBeAttendedTest {

    @Test
    public void maxEvents1() {
        final MaximumNumberEventsThatCanBeAttended solver = new MaximumNumberEventsThatCanBeAttended();
        final int[][] events = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        final int expected = 3;
        final int actual = solver.maxEvents(events);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxEvents2() {
        final MaximumNumberEventsThatCanBeAttended solver = new MaximumNumberEventsThatCanBeAttended();
        final int[][] events = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 2}
        };
        final int expected = 4;
        final int actual = solver.maxEvents(events);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxEvents3() {
        final MaximumNumberEventsThatCanBeAttended solver = new MaximumNumberEventsThatCanBeAttended();
        final int[][] events = {
                {1, 4},
                {4, 4},
                {2, 2},
                {3, 4},
                {1, 1}
        };
        final int expected = 4;
        final int actual = solver.maxEvents(events);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxEvents4() {
        final MaximumNumberEventsThatCanBeAttended solver = new MaximumNumberEventsThatCanBeAttended();
        final int[][] events = {
                {1, 100000}
        };
        final int expected = 1;
        final int actual = solver.maxEvents(events);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxEvents5() {
        final MaximumNumberEventsThatCanBeAttended solver = new MaximumNumberEventsThatCanBeAttended();
        final int[][] events = {
                {1, 1},
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {1, 6},
                {1, 7},
        };
        final int expected = 7;
        final int actual = solver.maxEvents(events);
        Assert.assertEquals(expected, actual);
    }
}