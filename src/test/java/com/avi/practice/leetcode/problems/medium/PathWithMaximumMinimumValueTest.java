package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Given a matrix of integers grid with m rows and n columns, find the maximum score of a path starting at [0,0] and ending at [m-1,n-1].
 * <p>
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 * <p>
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 * Explanation:
 * The path with the maximum score is highlighted in yellow.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * Output: 2
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= m, n <= 100
 * 0 <= grid[i][j] <= 109
 */
public class PathWithMaximumMinimumValueTest {

    private static final PathWithMaximumMinimumValue solver = new PathWithMaximumMinimumValue();

    @Test
    public void maximumMinimumPath1() {
        final int[][] grid = {
                {5, 4, 5},
                {1, 2, 6},
                {7, 4, 6}
        };
        final int expected = 4;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------");
        final int actual = solver.maximumMinimumPath(grid);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maximumMinimumPath2() {
        final int[][] grid = {
                {2, 2, 1, 2, 2, 2},
                {1, 2, 2, 2, 1, 2}
        };
        final int expected = 2;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------");
        final int actual = solver.maximumMinimumPath(grid);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maximumMinimumPath3() {
        final int[][] grid = {
                {3, 4, 6, 3, 4},
                {0, 2, 1, 1, 7},
                {8, 8, 3, 2, 7},
                {3, 2, 4, 9, 8},
                {4, 1, 2, 0, 0},
                {4, 6, 5, 4, 3},
        };
        final int expected = 3;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------");
        final int actual = solver.maximumMinimumPath(grid);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void maximumMinimumPath4() {
        final int[][] grid = {
                {5, 4, 3, 1},
                {7, 4, 5, 2},
                {4, 9, 8, 2},
                {2, 3, 6, 6},
        };
        final int expected = 4;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------");
        final int actual = solver.maximumMinimumPath(grid);
        Assert.assertEquals(expected, actual);
    }
}