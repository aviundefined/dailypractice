package com.avi.practice.leetcode.weeklycontest.num219;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

    private static final PartitioningIntoMinimumNumberOfDeciBinaryNumbers solver = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();

    @Test
    public void minPartitions1() {
        final String n = "32";
        final int expected = 3;
        final int actual = solver.minPartitions(n);
        Assert.assertEquals(n, expected, actual);
    }

    @Test
    public void minPartitions2() {
        final String n = "82734";
        final int expected = 8;
        final int actual = solver.minPartitions(n);
        Assert.assertEquals(n, expected, actual);
    }

    @Test
    public void minPartitions3() {
        final String n = "27346209830709182346";
        final int expected = 9;
        final int actual = solver.minPartitions(n);
        Assert.assertEquals(n, expected, actual);
    }
}