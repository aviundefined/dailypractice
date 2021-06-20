package com.avi.practice.company.google;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * <p>
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 * <p>
 * Input: matrix = [[1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class LongestIncreasingPathInMatrix {
    private static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int longestIncreasingPathBruteForce(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final boolean[][] visited = new boolean[m][n];
                final int curr = backtrack(i, j, matrix, visited);
                if (max < curr) {
                    max = curr;
                }
            }
        }
        return max;
    }

    private int backtrack(int i, int j, int[][] matrix, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int currMax = 1;
        for (int[] direction : directions) {
            final int newI = i + direction[0];
            final int newJ = j + direction[1];
            if (newI < 0 || newJ < 0 || newI >= matrix.length || newJ >= matrix[0].length || visited[newI][newJ] || matrix[newI][newJ] <= matrix[i][j]) {
                continue;
            }
            final int val = 1 + backtrack(newI, newJ, matrix, visited);
            if (val > currMax) {
                currMax = val;
            }
        }
        visited[i][j] = false;
        return currMax;
    }
}
