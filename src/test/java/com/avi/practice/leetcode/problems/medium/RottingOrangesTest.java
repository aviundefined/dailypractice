package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RottingOrangesTest {

    private static final RottingOranges solver = new RottingOranges();

    @Test
    public void orangesRotting11() {
        final int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        final int expected = 4;
        final int actual = solver.orangesRotting1(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }

    @Test
    public void orangesRotting12() {
        final int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        final int expected = -1;
        final int actual = solver.orangesRotting1(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }

    @Test
    public void orangesRotting13() {
        final int[][] grid = {
                {0, 2},
        };
        final int expected = 0;
        final int actual = solver.orangesRotting1(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }

    @Test
    public void orangesRotting14() {
        final int[][] grid = {
                {2, 1, 1},
                {1, 1, 1},
                {0, 0, 2}
        };
        final int expected = 2;
        final int actual = solver.orangesRotting1(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }

    @Test
    public void orangesRotting21() {
        final int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        final int expected = 4;
        final int actual = solver.orangesRotting2(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }

    @Test
    public void orangesRotting22() {
        final int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        final int expected = -1;
        final int actual = solver.orangesRotting2(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }

    @Test
    public void orangesRotting23() {
        final int[][] grid = {
                {0, 2},
        };
        final int expected = 0;
        final int actual = solver.orangesRotting2(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }

    @Test
    public void orangesRotting24() {
        final int[][] grid = {
                {2, 1, 1},
                {1, 1, 1},
                {0, 0, 2}
        };
        final int expected = 2;
        final int actual = solver.orangesRotting2(grid);
        System.out.println("--- initial ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        Assert.assertEquals(expected, actual);
        System.out.println("--- final ----");
        for(final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }
}