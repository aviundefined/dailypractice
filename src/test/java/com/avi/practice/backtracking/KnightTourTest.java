package com.avi.practice.backtracking;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KnightTourTest {

    private KnightTour tour8;

    @Before
    public void setup() {
        final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        tour8 = new KnightTour(8, xMove, yMove);
    }

    @After
    public void tearDown() {
        tour8 = null;
    }

    @Test
    public void solve() {
        final boolean solve = tour8.solve();
        Assert.assertTrue(solve);
    }
}