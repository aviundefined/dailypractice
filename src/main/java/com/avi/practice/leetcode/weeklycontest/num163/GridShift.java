package com.avi.practice.leetcode.weeklycontest.num163;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 22/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class GridShift {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return Collections.emptyList();
        }
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] newGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, m);
        }
        for (int shift = 1; shift <= k; shift++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j < m - 1) {
                        newGrid[i][j + 1] = grid[i][j];
                    } else if (i < n - 1 && j == m - 1) {
                        newGrid[i + 1][0] = grid[i][j];
                    } else if (i == n - 1 && j == m - 1) {
                        newGrid[0][0] = grid[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = newGrid[i][j];
                }
            }
        }
        final List<List<Integer>> shifted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(newGrid[i][j]);
            }
            shifted.add(row);
        }
        return shifted;
    }
}
