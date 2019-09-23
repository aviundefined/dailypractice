package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class GoldMine {

    private final int[][] mat;
    private final int m;
    private final int n;

    GoldMine(int[][] mat) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;
    }

    final int maxGold() {
        final int[][] dp = new int[m][n];
        int maxGold = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            dp[i][0] = mat[i][0];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                final int iMinus1_jMinus1 = val(dp, i - 1, j - 1);
                final int i_jMinus1 = val(dp, i, j - 1);
                final int iPlus1_jMinus1 = val(dp, i + 1, j - 1);
                dp[i][j] = mat[i][j] + CommonUtils.max(iMinus1_jMinus1, i_jMinus1, iPlus1_jMinus1);
                maxGold = Math.max(maxGold, dp[i][j]);
            }
        }
        return maxGold;
    }

    private int val(final int[][] dp, final int i, final int j) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            return dp[i][j];
        }
        return Integer.MIN_VALUE;
    }
}
