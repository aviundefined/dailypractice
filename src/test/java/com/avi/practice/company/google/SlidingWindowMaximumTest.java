package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 17/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SlidingWindowMaximumTest {

    @Test
    public void maxSlidingWindow1() {
        final SlidingWindowMaximum solver = new SlidingWindowMaximum();
        final int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        final int k = 3;
        final int[] expected = {3, 3, 5, 5, 6, 7};
        final int[] actual = solver.maxSlidingWindow(nums, k);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void maxSlidingWindow2() {
        final SlidingWindowMaximum solver = new SlidingWindowMaximum();
        final int[] nums = {1, -1};
        final int k = 1;
        final int[] expected = {1, -1};
        final int[] actual = solver.maxSlidingWindow(nums, k);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void maxSlidingWindow3() {
        final SlidingWindowMaximum solver = new SlidingWindowMaximum();
        final int[] nums = {7, 2, 4};
        final int k = 2;
        final int[] expected = {7, 4};
        final int[] actual = solver.maxSlidingWindow(nums, k);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }


}