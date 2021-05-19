package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RottingOranges {

    private static final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int orangesRotting2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        final int m = grid.length;
        final int n = grid[0].length;
        final Queue<Cell> q = new ArrayDeque<>();

        int countOfFreshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Cell(i, j));
                } else if (grid[i][j] == 1) {
                    countOfFreshOranges++;
                }
            }
        }
        int rottenDone = 0;
        int timeElapsed = 0;
        final Set<Cell> visited = new HashSet<>();
        while (!q.isEmpty()) {
            final Cell curr = q.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            for (final int[] direction : directions) {
                final int row = curr.row + direction[0];
                final int col = curr.col + direction[1];
                if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1) {
                    grid[row][col] = 2;
                    rottenDone++;
                    q.offer(new Cell(row, col, curr.time + 1));
                    if (timeElapsed < curr.time + 1) {
                        timeElapsed = curr.time + 1;
                    }
                }
            }
        }

        return countOfFreshOranges == rottenDone ? timeElapsed : -1;
    }

    public int orangesRotting1(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        final int m = grid.length;
        final int n = grid[0].length;
        final Queue<Cell> q = new ArrayDeque<>();

        int countOfFreshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Cell(i, j));
                } else if (grid[i][j] == 1) {
                    countOfFreshOranges++;
                }
            }
        }
        q.offer(new Cell(-1, -1));
        int rottenDone = 0;
        int timeElapsed = -1;

        while (!q.isEmpty()) {
            final Cell curr = q.poll();
            if (curr.row == -1) {
                timeElapsed++;
                if (!q.isEmpty()) {
                    q.offer(new Cell(-1, -1)); // start of new cell
                }
            } else {
                for (final int[] direction : directions) {
                    final int row = curr.row + direction[0];
                    final int col = curr.col + direction[1];
                    if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        rottenDone++;
                        q.offer(new Cell(row, col));
                    }
                }
            }
        }

        return countOfFreshOranges == rottenDone ? timeElapsed : -1;
    }

    private static final class Cell {
        private final int row;
        private final int col;
        private final int time;

        private Cell(final int row, final int col, final int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        private Cell(final int row, final int col) {
            this(row, col, 0);
        }
    }
}
