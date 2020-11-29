package com.avi.practice.company.microsoft.interviewbit;

import java.util.ArrayList;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SpiralOrder2 {

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

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

        return _convert(matrix);
    }

    final ArrayList<ArrayList<Integer>> _convert(int[][] matrix) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] ints : matrix) {
            final ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                row.add(ints[j]);
            }
            result.add(row);
        }
        return result;
    }
}
