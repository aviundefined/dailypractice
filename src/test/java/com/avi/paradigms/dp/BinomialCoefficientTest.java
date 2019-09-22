package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinomialCoefficientTest {

    @Test
    public void nCk() {
        final BinomialCoefficient solver = new BinomialCoefficient();
        {
            final int n = 5;
            final int k = 2;
            final int expected = 10;
            final int nCk = solver.nCk(n, k);
            Assert.assertEquals(String.format("%dC%d", n, k), expected, nCk);
        }

        {
            final int n = 0;
            final int k = 0;
            final int expected = 1;
            final int nCk = solver.nCk(n, k);
            Assert.assertEquals(String.format("%dC%d", n, k), expected, nCk);
        }

        {
            final int n = 10;
            final int k = 1;
            final int expected = 10;
            final int nCk = solver.nCk(n, k);
            Assert.assertEquals(String.format("%dC%d", n, k), expected, nCk);
        }

        {
            final int n = 5;
            final int k = 5;
            final int expected = 1;
            final int nCk = solver.nCk(n, k);
            Assert.assertEquals(String.format("%dC%d", n, k), expected, nCk);
        }

        {
            final int n = 5;
            final int k = 4;
            final int expected = 5;
            final int nCk = solver.nCk(n, k);
            Assert.assertEquals(String.format("%dC%d", n, k), expected, nCk);
        }
    }
}
