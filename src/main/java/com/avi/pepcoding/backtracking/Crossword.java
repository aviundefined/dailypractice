package com.avi.pepcoding.backtracking;

import java.util.Arrays;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Crossword {

    public final void solve(final char[][] board, final String[] words) {
        if (words == null || words.length == 0 || board == null || board.length == 0) {
            return;
        }
        backtrack(0, board, words);
    }

    private void backtrack(final int index, final char[][] board, final String[] words) {
        if (index == words.length) {
            print(board);
            return;
        }

        final String word = words[index];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if cell is empty or start with first character then it can be eligible spot
                if (board[i][j] == '-' || board[i][j] == word.charAt(0)) {
                    // now check if word can be placed horizontally
                    if (canPlaceHorizontally(board, word, i, j)) {
                        final boolean[] placed = placeHorizontally(board, word, i, j);
                        backtrack(index + 1, board, words);
                        unplacedHorizontally(board, placed, i, j);
                    }

                    // now check if word can be placed vertically
                    if (canPlaceVertically(board, word, i, j)) {
                        final boolean[] placed = placeVertically(board, word, i, j);
                        backtrack(index + 1, board, words);
                        unplacedVertically(board, placed, i, j);
                    }
                }
            }
        }
    }

    private void unplacedVertically(final char[][] board, final boolean[] placed, final int i, final int j) {
        for (int ii = 0; ii < board.length; ii++) {
            if (placed[ii]) {
                board[i + ii][j] = '-';
            }
        }
    }

    private boolean[] placeVertically(final char[][] board, final String word, final int i, final int j) {
        final boolean[] placed = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (board[i + ii][j] == '-') {
                placed[ii] = true;
                board[i + ii][j] = word.charAt(ii);
            }
        }
        return placed;
    }

    private boolean canPlaceVertically(final char[][] board, final String word, final int i, final int j) {
        if (i - 1 >= 0 && board[i - 1][j] != '+') {
            return false;
        }
        if (i + word.length() < board.length && board[i + +word.length()][j] != '+') {
            return false;
        }
        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= board.length) {
                return false;
            }
            if (board[i + ii][j] == '-' || board[i + ii][j] == word.charAt(ii)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private void unplacedHorizontally(final char[][] board, final boolean[] placed, final int i, final int j) {
        for (int jj = 0; jj < board.length; jj++) {
            if (placed[jj]) {
                board[i][j + jj] = '-';
            }
        }
    }

    private boolean[] placeHorizontally(final char[][] board, final String word, final int i, final int j) {
        final boolean[] placed = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (board[i][j + jj] == '-') {
                placed[jj] = true;
                board[i][j + jj] = word.charAt(jj);
            }
        }
        return placed;
    }

    private boolean canPlaceHorizontally(final char[][] board, final String word, final int i, final int j) {
        if (j - 1 >= 0 && board[i][j - 1] != '+') {
            return false;
        }
        if (j + word.length() < board[0].length && board[i][j + word.length()] != '+') {
            return false;
        }
        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= board[0].length) {
                return false;
            }
            if (board[i][j + jj] == '-' || board[i][j + jj] == word.charAt(jj)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private void print(final char[][] board) {
        for (final char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------");
    }

}
