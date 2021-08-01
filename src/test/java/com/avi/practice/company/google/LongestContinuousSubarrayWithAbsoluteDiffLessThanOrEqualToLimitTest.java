package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {

    @Test
    public void longestSubarray1() {
        final LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit solver = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        final int[] nums = {8, 2, 4, 7};
        final int limit = 4;
        final int expected = 2;
        final int actual = solver.longestSubarray(nums, limit);
        Assert.assertEquals(String.format("nums: %s, limit: %s", Arrays.toString(nums), limit), expected, actual);
    }

    @Test
    public void longestSubarray2() {
        final LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit solver = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        final int[] nums = {10, 1, 2, 4, 7, 2};
        final int limit = 5;
        final int expected = 4;
        final int actual = solver.longestSubarray(nums, limit);
        Assert.assertEquals(String.format("nums: %s, limit: %s", Arrays.toString(nums), limit), expected, actual);
    }

    @Test
    public void longestSubarray3() {
        final LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit solver = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        final int[] nums = {4,2,2,2,4,4,2,2};
        final int limit = 0;
        final int expected = 3;
        final int actual = solver.longestSubarray(nums, limit);
        Assert.assertEquals(String.format("nums: %s, limit: %s", Arrays.toString(nums), limit), expected, actual);
    }
}