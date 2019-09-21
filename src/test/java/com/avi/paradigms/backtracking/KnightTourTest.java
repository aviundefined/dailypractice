package com.avi.paradigms.backtracking;

import com.avi.paradigms.backtracking.KnightTour;
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

    private KnightTour tour;

    @Before
    public void setup() {
        tour = new KnightTour();
    }

    @After
    public void tearDown() {
        tour = null;
    }

    @Test
    public void solve() {
        final boolean solve = tour.solve(8);
        Assert.assertTrue(solve);
    }

    @Test
    public void testAll() {
        for (int i = 0; i <= 8; i++) {
            final boolean solve = tour.solve(i);
            if (i == 0 ||
                    i == 2
                    || i == 3
                    || i == 4
            ) {
                Assert.assertFalse(String.valueOf(i), solve);
            } else {
                Assert.assertTrue(String.valueOf(i), solve);
            }
        }
    }
}