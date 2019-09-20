package com.avi.practice.backtracking;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 20/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class NQueen {

    private static final int NOT_SET = 0;

    final boolean solve(final int numQueen, final int rows, final int cols) {
        System.out.println();
        if (numQueen == 0) {
            System.out.println("Number of queen is zero");
            return false;
        }
        if (numQueen > cols || numQueen > rows) {
            System.out.println(String.format("Number of queens are greater than either rows or cols or both: " +
                    "numQueen=%s, rows=%s, cols=%s", numQueen, rows, cols));
            return false;
        }
        final int[][] board = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = NOT_SET;
            }
        }
        // We will start putting queen column wise and we check for clashes with already placed queens.
        // In the current column, if we find a row for which there is no clash, we mark this row and column as part
        // of the solution. If we do not find such a row due to clashes then we backtrack and return false.
        if (_solve(board, 0, numQueen, rows, cols)) {
            System.out.println("Solution found. Printing board configuration");
            CommonUtils.printMatrix(board);
            return true;
        }
        System.out.println(String.format("No solution found for [%s] queens in %s x %s board", numQueen, rows, cols));
        return false;
    }

    private boolean _solve(final int[][] board, final int col, final int numQueen, final int rows, final int cols) {
        if (col >= numQueen) {
            return true;
        }
        for (int i = 0; i < rows; i++) {
            if (_isSafe(board, i, col, rows, cols)) {
                board[i][col] = 1;
                if (_solve(board, col + 1, numQueen, rows, cols)) {
                    return true;
                }
                board[i][col] = NOT_SET;
            }
        }
        return false;
    }

    private boolean _isSafe(final int[][] board, final int row, final int col, final int rows, final int cols) {
        // see if for current col all the rows are safe
        for (int j = 0; j <= col && j < cols; j++) {
            if (board[row][j] == 1) {
                return false;
            }
        }

        // Lower left diagonal
        for (int i = row, j = col; i < rows && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
