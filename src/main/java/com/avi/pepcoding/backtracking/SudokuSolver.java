package com.avi.pepcoding.backtracking;

import java.util.Arrays;

/**
 * Created by navinash on 23/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SudokuSolver {


    public static void main(String[] args) {
        final Solution solver = new Solution();
        final char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solver.solveSudoku(board);
    }

    public void solve(final int[][] sudoku) {
        if (sudoku == null || sudoku.length == 0) {
            System.out.println("Invalid Sudoku: null or empty");
            return;
        }
        display(sudoku, "Original");
        final int sudokuSize = sudoku.length;
        if (sudokuSize != sudoku[0].length) {
            System.out.println("Invalid Sudoku: Number of Rows and Columns should be equal");
            return;
        }
        final int gridSize = (int) Math.sqrt(sudokuSize);
        if (gridSize * gridSize != sudokuSize) {
            System.out.println("Invalid Sudoku: Length of grid should be perfect square");
            return;
        }

        final boolean isSolutionFound = backtrack(sudoku, 0, 0, sudokuSize, gridSize);
        System.out.println("------------------------");
    }

    private boolean backtrack(final int[][] sudoku, final int row, int col, int sudokuSize, int gridSize) {
        if (row == sudoku.length) {
            display(sudoku, "Solution");
            return true;
        }

        final int nextRow;
        final int nextCol;
        if (col == sudoku[0].length - 1) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        if (sudoku[row][col] != 0) {
            backtrack(sudoku, nextRow, nextCol, sudokuSize, gridSize);
        } else {
            for (int possible = 1; possible <= sudokuSize; possible++) {
                if (isValid(sudoku, possible, row, col, sudokuSize, gridSize)) {
                    sudoku[row][col] = possible;
                    final boolean isSolutionFound = backtrack(sudoku, nextRow, nextCol, sudokuSize, gridSize);
                    sudoku[row][col] = 0;
                    if (isSolutionFound) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(
            final int[][] sudoku,
            final int possible,
            final int row,
            final int col,
            final int sudokuSize,
            final int gridSize) {
        // check if possible can be put on row
        for (int i = 0; i < sudokuSize; i++) {
            if (sudoku[row][i] == possible) {
                return false;
            }
        }

        // check if possible can be put on col
        for (int i = 0; i < sudokuSize; i++) {
            if (sudoku[i][col] == possible) {
                return false;
            }
        }

        final int gridStartRow = (row / gridSize) * gridSize;
        final int gridStartCol = (col / gridSize) * gridSize;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (sudoku[gridStartRow + i][gridStartCol + j] == possible) {
                    return false;
                }
            }
        }
        return true;
    }

    private void display(int[][] sudoku, final String tag) {
        System.out.printf("------ %s -------\n", tag);
        for (final int[] row : sudoku) {
            System.out.println(Arrays.toString(row));
        }

    }

    private static final class Solution {
        private static final char E = '.';
        private char[][] board;
        private int n;
        private int gridSize;
        private final char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public void solveSudoku(char[][] board) {
            if(board == null || board.length == 0) {
                return;
            }
            this.board = board;
            this.n = board.length;
            final int gridSize = (int) Math.sqrt(n);
            this.gridSize = gridSize;

            solve(0, 0, board);
        }

        private boolean solve(final int row, final int col, final char[][] board) {
            if(row >= n) {
                print("solution", board);
                return true;
            }
            final int nextRow;
            final int nextCol;
            if(col == n - 1) {
                nextRow = row + 1;
                nextCol = 0;
            }else {
                nextRow = row;
                nextCol = col + 1;
            }

            boolean solved = false;
            if(board[row][col] == E) {
                for(final char val : chars) {
                    if(canPlace(row, col, val)) {
                        board[row][col] = val;
                        solved = solve(nextRow, nextCol, board);
                        board[row][col] = E;
                    }
                }
            }else {
                solved = solve(nextRow, nextCol, board);
            }
            return solved;
        }

        private boolean canPlace(final int row, final int col, final char val) {
            // check if same value is not in row
            for(int j = 0; j < n; j++) {
                if(board[row][j] == val) {
                    return false;
                }
            }

            // check if same value is not in col
            for(int i = 0; i < n; i++) {
                if(board[i][col] == val) {
                    return false;
                }
            }

            // check in grid
            final int startRow = (row / gridSize) * gridSize;
            final int startCol = (col / gridSize) * gridSize;
            for(int i = 0; i < gridSize; i++) {
                for(int j = 0; j < gridSize; j++) {
                    if(board[startRow + i][startCol + j] == val) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void print(final String tag, final char[][] grid) {
            System.out.printf("------ %s -------\n", tag);
            for(final char[] row : grid) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
