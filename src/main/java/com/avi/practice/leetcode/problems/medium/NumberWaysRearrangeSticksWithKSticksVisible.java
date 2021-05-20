package com.avi.practice.leetcode.problems.medium;

import java.util.Arrays;

/**
 * Created by navinash on 20/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberWaysRearrangeSticksWithKSticksVisible {

    public int rearrangeSticksDP(int n, int k) {
        // if we have arranged i sticks in an way that j sticks are visible from left, now if need to put the
        // smallest stick in a way that only j sticks are visible so if put the smallest stick in between the sticks then
        // we have i spots available and if we put the first sticks to the left most then we have to to make j sticks visible , we can use j - 1
        // if f(i,j) is function i.e. we are stacking i sticks in a way that j sticks are left visible, then
        // f(i, j) = (i - 1) * f(i - 1, j) + 1 * f[i - 1, j-1);

        // f(0, 0)
        final long[][] f = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = 0;
        }
        for (int i = 0; i <= k; i++) {
            f[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == j) {
                    f[i][j] = 1;
                } else if (i < j) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = ((i - 1) * f[i - 1][j] + f[i - 1][j - 1]) % 1000000007;
                }
            }
        }

        return (int) (f[n][k] % 1000000007);
    }

    public int rearrangeSticksMemoization(int n, int k) {
        final long[][] dp = new long[n + 1][k + 1];
        for (final long[] row : dp) {
            Arrays.fill(row, -1L);
        }
        recursion(n, k, dp);
        return (int) (dp[n][k] % 1000000007);
    }

    private long recursion(int n, int k, long[][] dp) {
        if (dp[n][k] == -1L) {
            if (n == k) {
                dp[n][k] = 1L;
            } else if (k == 0) {
                dp[n][k] = 0L;
            } else {
                dp[n][k] = ((n - 1) * recursion(n - 1, k, dp)) + recursion(n - 1, k - 1, dp);
            }
        }
        return dp[n][k];
    }
}
