package com.avi.pepcoding.graph;

import java.util.Arrays;

/**
 * Created by navinash on 01/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KnightsTour {

    public void knightsTour(final int[][] chess, int row, int col) {
        helper(chess, row, col, 1);
    }

    private void helper(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] > 0) {
            return;
        }
        if (move == chess.length * chess[0].length) {
            chess[row][col] = move;
            print(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = move;
        helper(chess, row - 2, col + 1, move + 1);
        helper(chess, row - 1, col + 2, move + 1);
        helper(chess, row + 1, col + 2, move + 1);
        helper(chess, row + 2, col + 1, move + 1);
        helper(chess, row + 2, col - 1, move + 1);
        helper(chess, row + 1, col - 2, move + 1);
        helper(chess, row - 1, col - 2, move + 1);
        helper(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    private void print(int[][] chess) {
        for (int[] row : chess) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------");
    }
}
