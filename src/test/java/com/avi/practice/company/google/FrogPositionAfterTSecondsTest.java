package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 19/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FrogPositionAfterTSecondsTest {

    @Test
    public void frogPosition1() {
        final int n = 7;
        final int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        final int t = 2;
        final int target = 4;
        final FrogPositionAfterTSeconds solver = new FrogPositionAfterTSeconds();
        final double expected = 0.16666666666666666;
        final double actual = solver.frogPosition(n, edges, t, target);
        System.out.printf("expected: %s, actual: %s\n", expected, actual);
        Assert.assertEquals(expected, actual, 2);
    }

    @Test
    public void frogPosition2() {
        final int n = 7;
        final int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        final int t = 2;
        final int target = 7;
        final FrogPositionAfterTSeconds solver = new FrogPositionAfterTSeconds();
        final double expected = 0.3333333333333333D;
        final double actual = solver.frogPosition(n, edges, t, target);
        System.out.printf("expected: %s, actual: %s\n", expected, actual);
        Assert.assertEquals(expected, actual, 2);
    }

    @Test
    public void frogPosition3() {
        final int n = 3;
        final int[][] edges = {{1, 2}, {3, 2}};
        final int t = 1;
        final int target = 2;
        final FrogPositionAfterTSeconds solver = new FrogPositionAfterTSeconds();
        final double expected = 1.00000D;
        final double actual = solver.frogPosition(n, edges, t, target);
        System.out.printf("expected: %s, actual: %s\n", expected, actual);
        Assert.assertEquals(expected, actual, 0);
    }
}