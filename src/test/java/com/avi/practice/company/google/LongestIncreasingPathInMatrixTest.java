package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestIncreasingPathInMatrixTest {

    private final static LongestIncreasingPathInMatrix solver = new LongestIncreasingPathInMatrix();

    @Test
    public void longestIncreasingPath1() {
        final int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        final int expected = 4;
        final int actual = solver.longestIncreasingPath(matrix);
        for (final int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        Assert.assertEquals(expected, actual);
        System.out.println("-------------");
    }

    @Test
    public void longestIncreasingPath2() {
        final int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        final int expected = 4;
        final int actual = solver.longestIncreasingPath(matrix);
        for (final int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        Assert.assertEquals(expected, actual);
        System.out.println("-------------");
    }

    @Test
    public void longestIncreasingPath3() {
        final int[][] matrix = {
                {1}
        };
        final int expected = 1;
        final int actual = solver.longestIncreasingPath(matrix);
        for (final int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        Assert.assertEquals(expected, actual);
        System.out.println("-------------");
    }
}