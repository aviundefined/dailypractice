package com.avi.practice.company.microsoft.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TwoSumTest {

    private static final TwoSum solver = new TwoSum();

    @Test
    public void twoSumBinarySearch1() {
        final int[] nums = {3, 2, 4};
        final int target = 6;
        final int[] expected = {1, 2};
        final int[] actual = solver.twoSumBinarySearch(nums, target);
        Assert.assertArrayEquals(String.format("nums: %s, target: %s", Arrays.toString(nums), target), expected, actual);
    }

    @Test
    public void twoSum1() {
        final int[] nums = {3, 2, 4};
        final int target = 6;
        final int[] expected = {1, 2};
        final int[] actual = solver.twoSum(nums, target);
        Assert.assertArrayEquals(String.format("nums: %s, target: %s", Arrays.toString(nums), target), expected, actual);
    }
}