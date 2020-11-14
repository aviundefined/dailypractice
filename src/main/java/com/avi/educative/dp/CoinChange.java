package com.avi.educative.dp;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CoinChange {

    public int coinChange(final int[] coins, final int total) {
        if (total == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }

        final int[][] dp = new int[coins.length][total + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= total; j++) {
            if (coins[0] <= j) {
                dp[0][j] = dp[0][j - coins[0]];
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coins[i] <= j) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        return dp[coins.length - 1][total];
    }
}
