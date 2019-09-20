package com.avi.practice.backtracking;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GraphColoringTest {

    @Test
    public void solve() {
        final int[][] graph = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        final GraphColoring solver = new GraphColoring(graph);
        {
            final int m = 1;
            final boolean solve = solver.solve(m);
            Assert.assertFalse(String.valueOf(m), solve);
        }
        {
            final int m = 2;
            final boolean solve = solver.solve(m);
            Assert.assertFalse(String.valueOf(m), solve);
        }
        {
            final int m = 3;
            final boolean solve = solver.solve(m);
            Assert.assertTrue(String.valueOf(m), solve);
        }
        {
            final int m = 4;
            final boolean solve = solver.solve(m);
            Assert.assertTrue(String.valueOf(m), solve);
        }
    }
}