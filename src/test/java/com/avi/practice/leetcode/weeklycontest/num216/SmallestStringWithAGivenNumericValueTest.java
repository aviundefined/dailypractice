package com.avi.practice.leetcode.weeklycontest.num216;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 23/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SmallestStringWithAGivenNumericValueTest {

    private static SmallestStringWithAGivenNumericValue solver = new SmallestStringWithAGivenNumericValue();

    @Test
    public void test1() {
        final int n = 3;
        final int k = 27;
        final String expected = "aay";
        final String actual = solver.getSmallestString(n, k);
        Assert.assertEquals(String.format("n: %d, k: %d", n, k), expected, actual);
    }

    @Test
    public void test2() {
        final int n = 5;
        final int k = 73;
        final String expected = "aaszz";
        final String actual = solver.getSmallestString(n, k);
        Assert.assertEquals(String.format("n: %d, k: %d", n, k), expected, actual);
    }
}