package com.avi.pepcoding.stack_queues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 02/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestAreaHistogramTest {

    @Test
    public void largestArea1() {
        final LargestAreaHistogram solver = new LargestAreaHistogram();
        final int[] arr = {6, 2, 5, 4, 5, 1, 6};
        final int expected = 12;
        final int actual = solver.largestRectangleArea(arr);
        Assert.assertEquals(Arrays.toString(arr), expected, actual);
    }

    @Test
    public void largestArea2() {
        final LargestAreaHistogram solver = new LargestAreaHistogram();
        final int[] arr = {1,1};
        final int expected = 2;
        final int actual = solver.largestRectangleArea(arr);
        Assert.assertEquals(Arrays.toString(arr), expected, actual);
    }

    @Test
    public void largestArea3() {
        final LargestAreaHistogram solver = new LargestAreaHistogram();
        final int[] arr = {0, 9};
        final int expected = 9;
        final int actual = solver.largestRectangleArea(arr);
        Assert.assertEquals(Arrays.toString(arr), expected, actual);
    }
}