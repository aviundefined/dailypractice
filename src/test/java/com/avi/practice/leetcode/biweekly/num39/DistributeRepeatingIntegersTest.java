package com.avi.practice.leetcode.biweekly.num39;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 21/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DistributeRepeatingIntegersTest {

    private static DistributeRepeatingIntegers solver = new DistributeRepeatingIntegers();

    @Test
    public void canDistribute() {
        {
            final int[] nums = {1, 2, 3, 4};
            final int[] quantity = {2};
            final boolean expected = false;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
        {
            final int[] nums = {1, 2, 3, 3};
            final int[] quantity = {2};
            final boolean expected = true;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
        {
            final int[] nums = {1, 1, 2, 2};
            final int[] quantity = {2, 2};
            final boolean expected = true;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
        {
            final int[] nums = {1, 1, 2, 3};
            final int[] quantity = {2, 2};
            final boolean expected = false;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
        {
            final int[] nums = {1, 1, 1, 1, 1};
            final int[] quantity = {2, 3};
            final boolean expected = true;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
        {
            final int[] nums = {1, 1, 2, 2, 1};
            final int[] quantity = {2, 2, 1};
            final boolean expected = true;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
        {
            final int[] nums = {357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357, 357};
            final int[] quantity = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            final boolean expected = false;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
        {
            final int[] nums = {1, 1, 1, 1, 2, 2, 2};
            final int[] quantity = {3, 2, 2};
            final boolean expected = true;
            final boolean actual = solver.canDistribute(nums, quantity);
            Assert.assertEquals(String.format("nums: %s, quantity: %s", Arrays.toString(nums), Arrays.toString(quantity)), expected, actual);
        }
    }
}