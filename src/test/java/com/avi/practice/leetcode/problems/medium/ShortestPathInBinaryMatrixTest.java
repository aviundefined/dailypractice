package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 21/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShortestPathInBinaryMatrixTest {
    private static final ShortestPathInBinaryMatrix solver = new ShortestPathInBinaryMatrix();

    @Test
    public void shortestPathBinaryMatrix1() {
        final int[][] grid = {
                {0, 1},
                {1, 0}
        };
        final int expected = 2;
        final int actual = solver.shortestPathBinaryMatrix(grid);
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shortestPathBinaryMatrix2() {
        final int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        final int expected = 4;
        final int actual = solver.shortestPathBinaryMatrix(grid);
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shortestPathBinaryMatrix3() {
        final int[][] grid = {
                {1,0,0},
                {1,1,0},
                {1,1,0}
        };
        final int expected = -1;
        final int actual = solver.shortestPathBinaryMatrix(grid);
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shortestPathBinaryMatrix4() {
        final int[][] grid = {
                {0,1,1,0,0,0},
                {0,1,0,1,1,0},
                {0,1,1,0,1,0},
                {0,0,0,1,1,0},
                {1,1,1,1,1,0},
                {1,1,1,1,1,0}
        };
        final int expected = 14;
        final int actual = solver.shortestPathBinaryMatrix(grid);
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------");
        Assert.assertEquals(expected, actual);
    }


}