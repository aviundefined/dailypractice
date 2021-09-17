package com.avi.pepcoding.graph.union_find;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 17/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MakingLargeIslandTest {

    @Test
    public void largestIsland1() {
        final MakingLargeIsland solver = new MakingLargeIsland();
        final int[][] grid = {{1, 0}, {0, 1}};
        final int expected = 3;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------");
        final int actual = solver.largestIsland(grid);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void largestIsland2() {
        final MakingLargeIsland solver = new MakingLargeIsland();
        final int[][] grid = {{1, 1}, {1, 0}};
        final int expected = 4;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------");
        final int actual = solver.largestIsland(grid);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void largestIsland3() {
        final MakingLargeIsland solver = new MakingLargeIsland();
        final int[][] grid = {{1, 1}, {1, 1}};
        final int expected = 4;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------");
        final int actual = solver.largestIsland(grid);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void largestIsland4() {
        final MakingLargeIsland solver = new MakingLargeIsland();
        final int[][] grid = {{0}};
        final int expected = 1;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------");
        final int actual = solver.largestIsland(grid);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void largestIsland5() {
        final MakingLargeIsland solver = new MakingLargeIsland();
        final int[][] grid = {{0, 0}, {0, 1}};
        final int expected = 2;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------");
        final int actual = solver.largestIsland(grid);
        Assert.assertEquals(expected, actual);
    }
}