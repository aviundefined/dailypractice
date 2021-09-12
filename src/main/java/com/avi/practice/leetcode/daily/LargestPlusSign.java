package com.avi.practice.leetcode.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 10/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LargestPlusSign {

    private static void print(final String tag, final int[][] matrix) {
        System.out.printf("------- %s -------\n", tag);
        for (final int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        final Set<Cell> minesSet = new HashSet<>();
        for (final int[] mine : mines) {
            minesSet.add(new Cell(mine[0], mine[1]));
        }

        final int[][] left = new int[n][n];
        final int[][] right = new int[n][n];
        final int[][] down = new int[n][n];
        final int[][] top = new int[n][n];

        // fill left
        for (int i = 0; i < n; i++) {
            int consecutiveOnes = 0;
            for (int j = 0; j < n; j++) {
                consecutiveOnes = minesSet.contains(new Cell(i, j)) ? 0 : consecutiveOnes + 1;
                left[i][j] = consecutiveOnes;
            }
        }

        // fill right
        for (int i = 0; i < n; i++) {
            int consecutiveOnes = 0;
            for (int j = n - 1; j >= 0; j--) {
                consecutiveOnes = minesSet.contains(new Cell(i, j)) ? 0 : consecutiveOnes + 1;
                right[i][j] = consecutiveOnes;
            }
        }

        // fill down
        for (int j = 0; j < n; j++) {
            int consecutiveOnes = 0;
            for (int i = 0; i < n; i++) {
                consecutiveOnes = minesSet.contains(new Cell(i, j)) ? 0 : consecutiveOnes + 1;
                down[i][j] = consecutiveOnes;
            }
        }

        // fill top
        for (int j = 0; j < n; j++) {
            int consecutiveOnes = 0;
            for (int i = n - 1; i >= 0; i--) {
                consecutiveOnes = minesSet.contains(new Cell(i, j)) ? 0 : consecutiveOnes + 1;
                top[i][j] = consecutiveOnes;
            }
        }

        print("left", left);
        print("right", right);
        print("top", top);
        print("down", down);
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int curr = Math.min(Math.min(left[i][j], right[i][j]), Math.min(top[i][j], down[i][j]));
                result = Math.max(curr, result);
            }
        }
        return result;
    }

    private static final class Cell {
        private final int x;
        private final int y;

        private Cell(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean equals(final Object o) {
            if(this == o) {
                return true;
            }

            final Cell cell = (Cell) o;
            return this.x == cell.x && this.y == cell.y;
        }
    }
}
