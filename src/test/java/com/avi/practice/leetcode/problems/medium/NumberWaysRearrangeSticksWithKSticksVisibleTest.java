package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 20/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberWaysRearrangeSticksWithKSticksVisibleTest {
    private static final NumberWaysRearrangeSticksWithKSticksVisible solver = new NumberWaysRearrangeSticksWithKSticksVisible();

    @Test
    public void rearrangeSticksDP1() {
        final int n = 3;
        final int k = 2;
        final int expected = 3;
        final int actual = solver.rearrangeSticksDP(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }

    @Test
    public void rearrangeSticksDP2() {
        final int n = 5;
        final int k = 5;
        final int expected = 1;
        final int actual = solver.rearrangeSticksDP(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }

    @Test
    public void rearrangeSticksDP3() {
        final int n = 20;
        final int k = 11;
        final int expected = 647427950;
        final int actual = solver.rearrangeSticksDP(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }

    @Test
    public void rearrangeSticksMemoization1() {
        final int n = 3;
        final int k = 2;
        final int expected = 3;
        final int actual = solver.rearrangeSticksMemoization(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }

    @Test
    public void rearrangeSticksMemoization2() {
        final int n = 5;
        final int k = 5;
        final int expected = 1;
        final int actual = solver.rearrangeSticksMemoization(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }

    @Test
    public void rearrangeSticksMemoization3() {
        final int n = 20;
        final int k = 11;
        final int expected = 647427950;
        final int actual = solver.rearrangeSticksMemoization(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }
}