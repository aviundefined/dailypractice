package com.avi.practice.company.microsoft.leetcode.medium;

/**
 * Created by navinash on 20/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int A) {
        int[][] matrix = new int[A][A];
        int T = 0;
        int B = A - 1;
        int L = 0;
        int R = A - 1;
        int dir = 0;
        int curr = 1;
        while (L <= R && T <= B) {
            if (dir == 0) {
                for (int i = L; i <= R; i++) {
                    matrix[T][i] = curr;
                    curr++;
                }
                T++;
                dir = 1;
            } else if (dir == 1) {
                for (int i = T; i <= B; i++) {
                    matrix[i][R] = curr;
                    curr++;
                }
                R--;
                dir = 2;
            } else if (dir == 2) {
                for (int i = R; i >= L; i--) {
                    matrix[B][i] = curr;
                    curr++;
                }
                B--;
                dir = 3;
            } else if (dir == 3) {
                for (int i = B; i >= T; i--) {
                    matrix[i][L] = curr;
                    curr++;
                }
                L++;
                dir = 0;
            }
        }
        return matrix;
    }
}
