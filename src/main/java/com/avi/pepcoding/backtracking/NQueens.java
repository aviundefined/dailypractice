package com.avi.pepcoding.backtracking;

import java.util.Arrays;

/**
 * Created by navinash on 24/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NQueens {

    public void place(final int n) {
        if (n <= 0) {
            return;
        }

        final int[][] board = new int[n][n];
        final int[] cols = new int[n];
        final int[] ld = new int[2 * n - 1]; // (n - 1 + r - c)
        final int[] rd = new int[2 * n - 1]; // (r + c)

        backtrack(board, 0, cols, ld, rd);
    }

    private void backtrack(int[][] board, int row, int[] cols, int[] ld, int[] rd) {
        if (row == board.length) {
            display(board);
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[row][col] == 0
                    && cols[col] == 0
                    && ld[board.length - 1 + row - col] == 0
                    && rd[row + col] == 0
            ) {
                board[row][col] = 1;
                cols[col] = 1;
                ld[board.length - 1 + row - col] = 1;
                rd[row + col] = 1;
                backtrack(board, row + 1, cols, ld, rd);
                board[row][col] = 0;
                cols[col] = 0;
                ld[board.length - 1 + row - col] = 0;
                rd[row + col] = 0;
            }
        }
    }


    private void display(final int[][] board) {
        for (final int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------");
    }
}
