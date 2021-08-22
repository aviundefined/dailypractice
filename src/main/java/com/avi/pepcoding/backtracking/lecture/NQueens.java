package com.avi.pepcoding.backtracking.lecture;

import java.util.Arrays;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NQueens {
    int n;
    int[][] board;
    int[] rows;
    int[] cols;
    int[] rd;
    int[] md;

    public void printAllConfigurations(final int n) {
        this.n = n;
        this.board = new int[n][n];
        this.rows = new int[n];
        this.cols = new int[n];
        this.rd = new int[2 * n - 1];
        this.md = new int[2 * n - 1];
        backtrack(0);
    }

    private void backtrack(int row) {
        if (row >= n) {
            for (final int[] arr : board) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("-----------------------");
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (canPlaceQueen(row, col)) {
                board[row][col] = 1;
                rows[row] = 1;
                cols[col] = 1;
                rd[row + col] = 1;
                md[n - 1 + row - col] = 1;
                board[row][col] = 1;
                backtrack(row + 1);
                board[row][col] = 0;
                rows[row] = 0;
                cols[col] = 0;
                rd[row + col] = 0;
                md[n - 1 + row - col] = 0;
            }
        }
    }

    private boolean canPlaceQueen(int row, int col) {
        if (board[row][col] != 0) {
            return false;
        }
        if (rows[row] != 0) {
            return false;
        }

        if (cols[col] != 0) {
            return false;
        }
        if (rd[row + col] != 0) {
            return false;
        }
        if (md[n - 1 + row - col] != 0) {
            return false;
        }
        return true;
    }
}
