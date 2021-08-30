package com.avi.practice.leetcode.daily;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 30/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PatchingArrayTest  {

    @Test
    public void testMinPatches1() {
        final PatchingArray solver =new PatchingArray();
        final int[] nums = {1, 3};
        final int n = 6;
        final int actual = 1;
        final int expected = solver.minPatches(nums, n);
        Assert.assertEquals(String.format("%s, %s", Arrays.toString(nums), n), actual, expected);
    }

    @Test
    public void testMinPatches2() {
        final PatchingArray solver =new PatchingArray();
        final int[] nums = {1, 5, 10};
        final int n = 20;
        final int actual = 2;
        final int expected = solver.minPatches(nums, n);
        Assert.assertEquals(String.format("%s, %s", Arrays.toString(nums), n), actual, expected);
    }

    @Test
    public void testMinPatches3() {
        final PatchingArray solver =new PatchingArray();
        final int[] nums = {1, 2, 2};
        final int n = 5;
        final int actual = 0;
        final int expected = solver.minPatches(nums, n);
        Assert.assertEquals(String.format("%s, %s", Arrays.toString(nums), n), actual, expected);
    }
}