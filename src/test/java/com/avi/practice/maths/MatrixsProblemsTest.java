package com.avi.practice.maths;


import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MatrixsProblemsTest {

    private static void print(final int[][] matrix, String tag) {
        System.out.printf("---------- %s -----------\n", tag);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void testTransposeSquareMatrix1() {
        final MatrixsProblem solver = new MatrixsProblem();
        final int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        print(matrix, "original");
        solver.transposeSquareMatrix(matrix);
        print(matrix, "transpose");
    }

    @Test
    public void testTransposeSquareMatrix2() {
        final MatrixsProblem solver = new MatrixsProblem();
        final int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        print(matrix, "original");
        solver.transposeSquareMatrix(matrix);
        print(matrix, "transpose");
    }

    @Test
    public void testTransposeSquareMatrix3() {
        final MatrixsProblem solver = new MatrixsProblem();
        final int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        print(matrix, "original");
        solver.transposeSquareMatrix(matrix);
        print(matrix, "transpose");
    }

    @Test
    public void testRotateSquareMatrix1() {
        final MatrixsProblem solver = new MatrixsProblem();
        final int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        print(matrix, "original");
        solver.rotateSquareMatrix(matrix);
        print(matrix, "rotated");
    }

    @Test
    public void testRotateSquareMatrix2() {
        final MatrixsProblem solver = new MatrixsProblem();
        final int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        print(matrix, "original");
        solver.rotateSquareMatrix(matrix);
        print(matrix, "rotated");
    }

    @Test
    public void testRotateSquareMatrix3() {
        final MatrixsProblem solver = new MatrixsProblem();
        final int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        print(matrix, "original");
        solver.rotateSquareMatrix(matrix);
        print(matrix, "rotated");
    }
}