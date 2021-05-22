package com.avi.practice.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by navinash on 22/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PathWithMaximumMinimumValue {

    private static final int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0},
    };

    public int maximumMinimumPath(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        final int m = grid.length;
        final int n = grid[0].length;

        // max heap
        final PriorityQueue<Cell> q = new PriorityQueue<>();
        q.add(new Cell(0, 0, grid[0][0]));
        int minValue = Integer.MAX_VALUE;
        final Set<Cell> visited = new HashSet<>();
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Cell curr = q.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (curr.value < minValue) {
                minValue = curr.value;
            }
            if (curr.row == m - 1 && curr.col == n - 1) {
                break;
            }
            for (final int[] direction : directions) {
                final int row = curr.row + direction[0];
                final int col = curr.col + direction[1];
                if (row >= 0 && col >= 0 && row < m && col < n) {
                    final Cell cell = new Cell(row, col, Math.min(curr.value, grid[row][col]));
                    if (visited.contains(cell)) {
                        continue;
                    }
                    q.offer(cell);
                }
            }
        }
        return minValue;
    }

    private static final class Cell implements Comparable<Cell> {
        private final int row;
        private final int col;
        private final int value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public int compareTo(Cell o) {
            return o.value - this.value;
        }
    }
}
