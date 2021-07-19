package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShortestPathGridObstaclesEliminationTest {

    @Test
    public void shortestPath1() {
        final ShortestPathGridObstaclesElimination solver = new ShortestPathGridObstaclesElimination();
        final int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        final int k = 1;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of Obstacles which can be removed: " + k);
        final int expected = 6;
        final int actual = solver.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shortestPath2() {
        final ShortestPathGridObstaclesElimination solver = new ShortestPathGridObstaclesElimination();
        final int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        final int k = 0;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of Obstacles which can be removed: " + k);
        final int expected = 10;
        final int actual = solver.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shortestPath3() {
        final ShortestPathGridObstaclesElimination solver = new ShortestPathGridObstaclesElimination();
        final int[][] grid = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        final int k = 1;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of Obstacles which can be removed: " + k);
        final int expected = -1;
        final int actual = solver.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shortestPath4() {
        final ShortestPathGridObstaclesElimination solver = new ShortestPathGridObstaclesElimination();
        final int[][] grid = {
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 0}
        };
        final int k = 1;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of Obstacles which can be removed: " + k);
        final int expected = 13;
        final int actual = solver.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shortestPath5() {
        final ShortestPathGridObstaclesElimination solver = new ShortestPathGridObstaclesElimination();
        final int[][] grid = {
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        final int k = 1;
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Number of Obstacles which can be removed: " + k);
        final int expected = 16;
        final int actual = solver.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);
    }
}