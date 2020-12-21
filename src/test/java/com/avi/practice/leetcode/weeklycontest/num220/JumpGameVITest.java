package com.avi.practice.leetcode.weeklycontest.num220;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 21/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGameVITest {

    private static final JumpGameVI solver = new JumpGameVI();

    @Test
    public void maxResult1() {
        final int[] nums = {1, -1, -2, 4, -7, 3};
        final int k = 2;
        final int expected = 7;
        final int actual = solver.maxResult(nums, k);
        Assert.assertEquals(String.format("%s, %d", Arrays.toString(nums), k), expected, actual);
    }

    @Test
    public void maxResult2() {
        final int[] nums = {1, -5, -20, 4, -1, 3, -6, -3};
        final int k = 2;
        final int expected = 0;
        final int actual = solver.maxResult(nums, k);
        Assert.assertEquals(String.format("%s, %d", Arrays.toString(nums), k), expected, actual);
    }

    @Test
    public void maxResult3() {
        final int[] nums = {10, -5, -2, 4, 0, 3};
        final int k = 3;
        final int expected = 17;
        final int actual = solver.maxResult(nums, k);
        Assert.assertEquals(String.format("%s, %d", Arrays.toString(nums), k), expected, actual);
    }
}