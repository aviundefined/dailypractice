package com.avi.practice.leetcode.monthly.august2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 04/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MakingALargeIslandTest {


    @Test
    public void largestIsland1() {
        final MakingALargeIsland solver = new MakingALargeIsland();
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
        final MakingALargeIsland solver = new MakingALargeIsland();
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
        final MakingALargeIsland solver = new MakingALargeIsland();
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
        final MakingALargeIsland solver = new MakingALargeIsland();
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
        final MakingALargeIsland solver = new MakingALargeIsland();
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