package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternatingTest {
    private static final MinimumNumberOfSwapsToMakeTheBinaryStringAlternating solver = new MinimumNumberOfSwapsToMakeTheBinaryStringAlternating();

    @Test
    public void minSwaps1() {
        final String s = "111000";
        final int expected = 1;
        final int actual = solver.minSwaps(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void minSwaps2() {
        final String s = "010";
        final int expected = 0;
        final int actual = solver.minSwaps(s);
        Assert.assertEquals(s, expected, actual);
    }


    @Test
    public void minSwaps3() {
        final String s = "1110";
        final int expected = -1;
        final int actual = solver.minSwaps(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void minSwaps4() {
        final String s = "1";
        final int expected = 0;
        final int actual = solver.minSwaps(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void minSwaps5() {
        final String s = "0";
        final int expected = 0;
        final int actual = solver.minSwaps(s);
        Assert.assertEquals(s, expected, actual);
    }
}