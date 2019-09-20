package com.avi.practice.backtracking;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class KnightTour {
    private static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int NOT_SET = -1;

    final boolean solve(final int n) {
        if (n == 0) {
            System.out.println("No solution found for grid: " + n);
            return false; // if grid size is 0 then return false
        }
        final int[][] sol = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = NOT_SET;
            }
        }
        sol[0][0] = 0;
        if (_solve(0, 0, 1, sol, n)) {
            System.out.println("Solution found for grid: " + n);
            CommonUtils.printMatrix(sol);
            return true;
        }
        System.out.println("No solution found for grid: " + n);
        return false;
    }

    private boolean _solve(final int x, final int y, final int numMove, final int[][] sol, final int n) {
        if (numMove == n * n) {
            return true; // solution found
        }
        for (int i = 0; i < xMove.length; i++) {
            final int nextX = x + xMove[i];
            final int nextY = y + yMove[i];
            if (_isSafe(nextX, nextY, sol, n)) {
                sol[nextX][nextY] = numMove;
                if (_solve(nextX, nextY, numMove + 1, sol, n)) {
                    return true;
                }
                sol[nextX][nextY] = NOT_SET;
            }
        }
        return false;
    }

    private boolean _isSafe(final int x, final int y, final int[][] sol, final int n) {
        //noinspection RedundantIfStatement
        if (x >= 0 && x < n // x in bound
                && y >= 0 && y < n // y in bound
                && sol[x][y] == NOT_SET // solution doesn't added already for x and y
        ) {
            return true;
        }
        return false;
    }
}
