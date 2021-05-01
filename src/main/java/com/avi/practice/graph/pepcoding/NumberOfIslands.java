package com.avi.practice.graph.pepcoding;

import java.util.Arrays;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberOfIslands {

    public final int numberOfIslands(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int count = 0;
        final int m = matrix.length;
        final int n = matrix[0].length;
        final boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    helper(matrix, i, j, visited, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(int[][] matrix, int i, int j, boolean[][] visited, int m, int n) {
        if (i < 0 || j < 0 || i >= n || j >= n || matrix[i][j] == 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        helper(matrix, i - 1, j, visited, m, n);
        helper(matrix, i + 1, j, visited, m, n);
        helper(matrix, i, j + 1, visited, m, n);
        helper(matrix, i, j - 1, visited, m, n);
    }
}
