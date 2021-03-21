package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 21/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SubarraySumEqualsKTest {

    private static final SubarraySumEqualsK solver = new SubarraySumEqualsK();

    @Test
    public void subarraySum1() {
        final int[] nums = {1, 1, 1};
        final int k = 2;
        final int expected = 2;
        final int actual = solver.subarraySum(nums, k);
        Assert.assertEquals(String.format("%s -> %s", Arrays.toString(nums), k), expected, actual);
    }

    @Test
    public void subarraySum2() {
        final int[] nums = {1, 2, 3};
        final int k = 3;
        final int expected = 2;
        final int actual = solver.subarraySum(nums, k);
        Assert.assertEquals(String.format("%s -> %s", Arrays.toString(nums), k), expected, actual);
    }

    @Test
    public void subarraySum3() {
        final int[] nums = {-1, -1, 1};
        final int k = 0;
        final int expected = 1;
        final int actual = solver.subarraySum(nums, k);
        Assert.assertEquals(String.format("%s -> %s", Arrays.toString(nums), k), expected, actual);
    }

    @Test
    public void subarraySum4() {
        final int[] nums = {1,2,1,2,1};
        final int k = 3;
        final int expected = 4;
        final int actual = solver.subarraySum(nums, k);
        Assert.assertEquals(String.format("%s -> %s", Arrays.toString(nums), k), expected, actual);
    }
}