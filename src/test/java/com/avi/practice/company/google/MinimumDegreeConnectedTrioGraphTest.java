package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 16/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumDegreeConnectedTrioGraphTest {

    @Test
    public void minTrioDegree1() {
        final MinimumDegreeConnectedTrioGraph solver = new MinimumDegreeConnectedTrioGraph();
        final int[][] edges = {{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}};
        final int n = 6;
        final int expected = 3;
        final int actual = solver.minTrioDegree(n, edges);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minTrioDegree2() {
        final MinimumDegreeConnectedTrioGraph solver = new MinimumDegreeConnectedTrioGraph();
        final int[][] edges = {{1,3},{4,1},{4,3},{2,5},{5,6},{6,7},{7,5},{2,6}};
        final int n = 7;
        final int expected = 0;
        final int actual = solver.minTrioDegree(n, edges);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minTrioDegree_TLE1() {
        final MinimumDegreeConnectedTrioGraph solver = new MinimumDegreeConnectedTrioGraph();
        final int[][] edges = {{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}};
        final int n = 6;
        final int expected = 3;
        final int actual = solver.minTrioDegree_TLE(n, edges);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minTrioDegree_TLE2() {
        final MinimumDegreeConnectedTrioGraph solver = new MinimumDegreeConnectedTrioGraph();
        final int[][] edges = {{1,3},{4,1},{4,3},{2,5},{5,6},{6,7},{7,5},{2,6}};
        final int n = 7;
        final int expected = 0;
        final int actual = solver.minTrioDegree_TLE(n, edges);
        Assert.assertEquals(expected, actual);
    }
}