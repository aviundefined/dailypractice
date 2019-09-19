package com.avi.practice.backtracking;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class KnightTour {
    private static final int NOT_SET = -1;
    private final int n;
    private final int[] xMove;
    private final int[] yMove;

    KnightTour(final int n, final int[] xMove, final int[] yMove) {
        this.n = n;
        this.xMove = xMove;
        this.yMove = yMove;
    }

    final boolean solve() {
        final int[][] sol = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = NOT_SET;
            }
        }
        sol[0][0] = 0;
        if (_solve(0, 0, 1, sol)) {
            CommonUtils.printMatrix(sol);
            return true;
        }
        return false;
    }

    private boolean _solve(final int x, final int y, final int numMove, final int[][] sol) {
        if (numMove == n * n) {
            return true; // solution found
        }
        for (int i = 0; i < xMove.length; i++) {
            final int nextX = x + xMove[i];
            final int nextY = y + yMove[i];
            if (_isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = numMove;
                if (_solve(nextX, nextY, numMove + 1, sol)) {
                    return true;
                } else {
                    sol[nextX][nextY] = NOT_SET;
                }
            }
        }
        return false;
    }

    private boolean _isSafe(final int x, final int y, final int[][] sol) {
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
