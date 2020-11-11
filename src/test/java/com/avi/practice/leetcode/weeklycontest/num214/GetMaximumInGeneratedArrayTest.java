package com.avi.practice.leetcode.weeklycontest.num214;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GetMaximumInGeneratedArrayTest {

    private final GetMaximumInGeneratedArray solver = new GetMaximumInGeneratedArray();
    @Test
    public void getMaximumGenerated() {

        {
            final int n = 3;
            final int expected = 2;
            final int actual = solver.getMaximumGenerated(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }

        {
            final int n = 7;
            final int expected = 3;
            final int actual = solver.getMaximumGenerated(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
    }
}