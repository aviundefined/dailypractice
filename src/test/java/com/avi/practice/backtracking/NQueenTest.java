package com.avi.practice.backtracking;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NQueenTest {

    private NQueen solver;

    @Before
    public void setup() {
        solver = new NQueen();
    }

    @After
    public void tearDown() {
        solver = null;
    }

    @Test
    public void solve() {
        {
            final int numQueen = 0;
            final int rows = 4;
            final int cols = 4;
            final String msg = String.format("numQueen=%d, grid=%d x %d", numQueen, rows, cols);
            final boolean isNQueenSolved = solver.solve(numQueen, rows, cols);
            Assert.assertFalse(msg, isNQueenSolved);
        }
        {
            final int numQueen = 4;
            final int rows = 3;
            final int cols = 3;
            final String msg = String.format("numQueen=%d, grid=%d x %d", numQueen, rows, cols);
            final boolean isNQueenSolved = solver.solve(numQueen, rows, cols);
            Assert.assertFalse(msg, isNQueenSolved);
        }
        {
            final int numQueen = 4;
            final int rows = 3;
            final int cols = 4;
            final String msg = String.format("numQueen=%d, grid=%d x %d", numQueen, rows, cols);
            final boolean isNQueenSolved = solver.solve(numQueen, rows, cols);
            Assert.assertFalse(msg, isNQueenSolved);
        }
        {
            final int numQueen = 4;
            final int rows = 4;
            final int cols = 3;
            final String msg = String.format("numQueen=%d, grid=%d x %d", numQueen, rows, cols);
            final boolean isNQueenSolved = solver.solve(numQueen, rows, cols);
            Assert.assertFalse(msg, isNQueenSolved);
        }
        {
            final int numQueen = 4;
            final int rows = 4;
            final int cols = 4;
            final String msg = String.format("numQueen=%d, grid=%d x %d", numQueen, rows, cols);
            final boolean isNQueenSolved = solver.solve(numQueen, rows, cols);
            Assert.assertTrue(msg, isNQueenSolved);
        }
    }
}