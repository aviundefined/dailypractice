package com.avi.paradigms.dp;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class TilingProblem {

    final int numWays(final int n, final int m) {
        if (n == 0) {
            return 0;
        }
        if (n >= 1 && n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }
        final int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else if (i > m) {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }
}
