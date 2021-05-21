package com.avi.practice.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * <p>
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * <p>
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Example 3:
 * <p>
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
public class ShortestPathInBinaryMatrix {

    private static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {1, 1},
            {-1, -1},
            {1, -1},
            {-1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        final int m = grid.length;
        final int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        final Queue<Cell> q = new ArrayDeque<>();
        q.offer(new Cell(0, 0, 1));

        int weight = 0;
        boolean isFound = false;
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Cell curr = q.poll();
            if (grid[curr.row][curr.col] == 1) {
                continue;
            }
            grid[curr.row][curr.col] = 1;
            if (curr.row == m - 1 && curr.col == n - 1) {
                isFound = true;
                weight = curr.weight;
                break;
            }
            for (int[] direction : directions) {
                final int row = curr.row + direction[0];
                final int col = curr.col + direction[1];
                if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] != 1) {
                    q.offer(new Cell(row, col, curr.weight + 1));
                }
            }
        }

        return isFound ? weight : -1;
    }

    private final static class Cell implements Comparable<Cell> {
        private final int row;
        private final int col;
        private final int weight;

        public Cell(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Cell o) {
            return this.weight - o.weight;
        }
    }
}
