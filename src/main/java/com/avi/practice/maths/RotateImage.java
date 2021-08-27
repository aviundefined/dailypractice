package com.avi.practice.maths;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RotateImage {

    public int[][] rotate(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        final int n = matrix.length;
        if (n != matrix[0].length) {
            throw new RuntimeException(String.format("Not a square matrix: %s, %s", n, matrix[0].length));
        }

        // matrix[i][j] -> matrix[k][n - 1 - i] k in [0, n - 1]
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, row[j]);
                min = Math.min(min, row[j]);
            }
        }
        if (min < 0) {
            final int offset = Math.abs(min) + 1;
            // apply offset
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] += offset;
                    max = Math.max(max, matrix[i][j]);
                }
            }
        }
        max++;

        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                final int a = matrix[i][j];
                final int b = matrix[n - 1 - j][i];
                matrix[i][j] = a + max * (b % max);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] / max;
            }
        }

        if (min < 0) {
            final int offset = Math.abs(min) + 1;
            // reduce offset
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] -= offset;
                }
            }
        }
        return matrix;
    }
}
