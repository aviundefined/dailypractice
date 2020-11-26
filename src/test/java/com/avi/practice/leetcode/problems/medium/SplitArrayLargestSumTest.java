package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 25/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SplitArrayLargestSumTest {

    private static final SplitArrayLargestSum solver = new SplitArrayLargestSum();

    @Test
    public void splitArray1() {
        final int[] nums = {7, 2, 5, 10, 8};
        final int m = 2;
        final int expected = 18;
        final int actual = solver.splitArray(nums, m);
        Assert.assertEquals(String.format("arr: %s, number of sub arrays: %d", Arrays.toString(nums), m), expected, actual);
    }

    @Test
    public void splitArray2() {
        final int[] nums = {1, 2, 3, 4, 5};
        final int m = 2;
        final int expected = 9;
        final int actual = solver.splitArray(nums, m);
        Assert.assertEquals(String.format("arr: %s, number of sub arrays: %d", Arrays.toString(nums), m), expected, actual);
    }

    @Test
    public void splitArray3() {
        final int[] nums = {1, 4, 4};
        final int m = 3;
        final int expected = 4;
        final int actual = solver.splitArray(nums, m);
        Assert.assertEquals(String.format("arr: %s, number of sub arrays: %d", Arrays.toString(nums), m), expected, actual);
    }

    @Test
    public void isPossible1() {
        final int[] nums = {7, 2, 5, 10, 8};
        final int m = 2;
        final int sum = 18;
        final boolean expected = true;
        final boolean actual = solver.isPossible(nums, m, sum);
        Assert.assertEquals(String.format("arr: %s, number of sub arrays: %d", Arrays.toString(nums), m), expected, actual);
    }

    @Test
    public void isPossible2() {
        final int[] nums = {1, 2, 3, 4, 5};
        final int m = 2;
        final int sum = 9;
        final boolean expected = true;
        final boolean actual = solver.isPossible(nums, m, sum);
        Assert.assertEquals(String.format("arr: %s, number of sub arrays: %d", Arrays.toString(nums), m), expected, actual);
    }

    @Test
    public void isPossible3() {
        final int[] nums = {1, 4, 4};
        final int m = 3;
        final int sum = 4;
        final boolean expected = true;
        final boolean actual = solver.isPossible(nums, m, sum);
        Assert.assertEquals(String.format("arr: %s, number of sub arrays: %d", Arrays.toString(nums), m), expected, actual);
    }
}