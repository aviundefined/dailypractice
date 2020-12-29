package com.avi.practice.company.microsoft.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 27/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestNumberTest {

    private static final LargestNumber solver = new LargestNumber();

    @Test
    public void largestNumber1() {
        final int[] nums = {10, 2};
        final String expected = "210";
        final String actual = solver.largestNumber(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void largestNumber2() {
        final int[] nums = {3,30,34,5,9};
        final String expected = "9534330";
        final String actual = solver.largestNumber(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void largestNumber3() {
        final int[] nums = {1};
        final String expected = "1";
        final String actual = solver.largestNumber(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void largestNumber4() {
        final int[] nums = {10};
        final String expected = "10";
        final String actual = solver.largestNumber(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }

    @Test
    public void largestNumber5() {
        final int[] nums = {0, 0};
        final String expected = "0";
        final String actual = solver.largestNumber(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}