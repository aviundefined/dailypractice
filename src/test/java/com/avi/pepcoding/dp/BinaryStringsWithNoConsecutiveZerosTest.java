package com.avi.pepcoding.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinaryStringsWithNoConsecutiveZerosTest {

    private static final BinaryStringsWithNoConsecutiveZeros solver = new BinaryStringsWithNoConsecutiveZeros();

    @Test
    public void nums0() {
        final int n = 0;
        final int expected = 0;
        final int actual = solver.nums(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }

    @Test
    public void nums1() {
        final int n = 1;
        final int expected = 1;
        final int actual = solver.nums(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }

    @Test
    public void nums2() {
        final int n = 2;
        final int expected = 3;
        final int actual = solver.nums(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }

    @Test
    public void nums3() {
        final int n = 3;
        final int expected = 5;
        final int actual = solver.nums(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }
}