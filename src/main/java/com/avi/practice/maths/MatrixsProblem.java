package com.avi.practice.maths;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MatrixsProblem {

    public void transposeSquareMatrix(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        final int n = matrix.length;
        if (n != matrix[0].length) {
            throw new RuntimeException("not a square matrix");
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                final int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void rotateSquareMatrix(final int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        final int n = matrix.length;
        if (n != matrix[0].length) {
            throw new RuntimeException("not a square matrix");
        }

        transposeSquareMatrix(matrix);
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                final int tmp = matrix[i][j];
                matrix[i][j] =  matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
