package com.avi.practice.company.microsoft.interviewbit;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example:
 * <p>
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return
 * <p>
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
public class SpiralOrder1 {

    public int[] spiralOrder(final int[][] A) {
        final int m = A.length;
        final int n = A[0].length;
        int T = 0;
        int B = m - 1;
        int L = 0;
        int R = n - 1;
        int dir = 0;
        final int[] result = new int[m * n];
        int idx = 0;
        while (T <= B && L <= R) {

            if (dir == 0) { // Left to Right
                for (int i = L; i <= R; i++) {
                    result[idx] = A[T][i];
                    idx++;
                }
                T++;
                dir = 1;
            } else if (dir == 1) { // Top to Bottom
                for (int i = T; i <= B; i++) {
                    result[idx] = A[i][R];
                    idx++;
                }
                R--;
                dir = 2;
            } else if (dir == 2) { // Right to Left
                for (int i = R; i >= L; i--) {
                    result[idx] = A[B][i];
                    idx++;
                }
                B--;
                dir = 3;
            } else if (dir == 3) { // Bottom to Top
                for (int i = B; i >= T; i--) {
                    result[idx] = A[i][L];
                    idx++;
                }
                L++;
                dir = 0;
            }
        }
        return result;
    }
}
