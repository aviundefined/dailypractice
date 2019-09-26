package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TilingProblemTest {

    @Test
    public void numWays() {
        final TilingProblem solver = new TilingProblem();
        {
            final int n = 7;
            final int m = 4;
            final int expected = 5;
            final int numWays = solver.numWays(n, m);
            Assert.assertEquals(String.format("%d * %d", n, m), expected, numWays);
        }
        {
            final int n = 8;
            final int m = 2;
            final int expected = 34;
            final int numWays = solver.numWays(n, m);
            Assert.assertEquals(String.format("%d * %d", n, m), expected, numWays);
        }
    }
}
