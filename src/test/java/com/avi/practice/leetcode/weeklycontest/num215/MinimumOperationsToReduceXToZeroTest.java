package com.avi.practice.leetcode.weeklycontest.num215;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumOperationsToReduceXToZeroTest {

    private static final MinimumOperationsToReduceXToZero solver = new MinimumOperationsToReduceXToZero();

    @Test
    public void minOperations() {
        {
            final int[] nums = {1, 1, 4, 2, 3};
            final int x = 5;
            final int expected = 2;
            final int actual = solver.minOperations(nums, x);
            Assert.assertEquals(String.format("arr: %s, sum: [%d]", Arrays.toString(nums), x), expected, actual);
        }
        {
            final int[] nums = {5, 6, 7, 8, 9};
            final int x = 4;
            final int expected = -1;
            final int actual = solver.minOperations(nums, x);
            Assert.assertEquals(String.format("arr: %s, sum: [%d]", Arrays.toString(nums), x), expected, actual);
        }
        {
            final int[] nums = {3, 2, 20, 1, 1, 3};
            final int x = 10;
            final int expected = 5;
            final int actual = solver.minOperations(nums, x);
            Assert.assertEquals(String.format("arr: %s, sum: [%d]", Arrays.toString(nums), x), expected, actual);
        }
        {
            final int[] nums = {1, 1, 3, 2, 2, 4};
            final int x = 7;
            final int expected = 3;
            final int actual = solver.minOperations(nums, x);
            Assert.assertEquals(String.format("arr: %s, sum: [%d]", Arrays.toString(nums), x), expected, actual);
        }
    }
}