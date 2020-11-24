package com.avi.practice.leetcode.weeklycontest.num216;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 24/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WaysToMakeArrayFairTest {

    private static final WaysToMakeArrayFair solver = new WaysToMakeArrayFair();

    @Test
    public void waysToMakeFair1() {
        final int[] nums = {2, 1, 6, 4};
        final int expected = 1;
        final int actual = solver.waysToMakeFair(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void waysToMakeFair2() {
        final int[] nums = {1, 1, 1};
        final int expected = 3;
        final int actual = solver.waysToMakeFair(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void waysToMakeFair3() {
        final int[] nums = {1, 2, 3};
        final int expected = 0;
        final int actual = solver.waysToMakeFair(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}