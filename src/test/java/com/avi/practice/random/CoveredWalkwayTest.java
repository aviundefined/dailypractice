package com.avi.practice.random;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 24/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CoveredWalkwayTest {

    @Test
    public void minCost1() {
        final CoveredWalkway solver = new CoveredWalkway();
        final int c = 5000;
        final int[] arr = {1, 23, 45, 67, 101, 124, 560, 789, 990, 1019};
        final long expected = 30726L;
        final long actual = solver.minCost(arr, c);
        Assert.assertEquals(expected, actual);
    }
}