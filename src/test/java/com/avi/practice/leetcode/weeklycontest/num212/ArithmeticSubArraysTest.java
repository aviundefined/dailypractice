package com.avi.practice.leetcode.weeklycontest.num212;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 28/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ArithmeticSubArraysTest {

    final ArithmeticSubArrays solver = new ArithmeticSubArrays();

    @Test
    public void test1() {
        final int[] nums = {4, 6, 5, 9, 3, 7};
        final int[] l = {0, 0, 2};
        final int[] r = {2, 3, 5};
        final List<Boolean> expected = Arrays.asList(true, false, true);
        final List<Boolean> actual = solver.checkArithmeticSubarrays(nums, l, r);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        final int[] nums = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        final int[] l = {0, 1, 6, 4, 8, 7};
        final int[] r = {4, 4, 9, 7, 9, 10};
        final List<Boolean> expected = Arrays.asList(false, true, false, false, true, true);
        final List<Boolean> actual = solver.checkArithmeticSubarrays(nums, l, r);
        Assert.assertEquals(expected, actual);
    }
}