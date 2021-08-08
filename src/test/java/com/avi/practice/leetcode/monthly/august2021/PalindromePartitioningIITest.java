package com.avi.practice.leetcode.monthly.august2021;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 08/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PalindromePartitioningIITest {

    @Test
    public void minCut1() {
        final PalindromePartitioningII solver =new PalindromePartitioningII();
        final String s = "aab";
        final int expected = 1;
        final int actual = solver.minCut(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void minCut2() {
        final PalindromePartitioningII solver =new PalindromePartitioningII();
        final String s = "coder";
        final int expected = 4;
        final int actual = solver.minCut(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void naiveDP_TLE1() {
        final PalindromePartitioningII solver =new PalindromePartitioningII();
        final String s = "aab";
        final int expected = 1;
        final int actual = solver.naiveDP_TLE(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void naiveDP_TLE2() {
        final PalindromePartitioningII solver =new PalindromePartitioningII();
        final String s = "coder";
        final int expected = 4;
        final int actual = solver.naiveDP_TLE(s);
        Assert.assertEquals(s, expected, actual);
    }
}