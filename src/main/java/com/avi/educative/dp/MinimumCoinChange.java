package com.avi.educative.dp;

import java.util.Arrays;

/**
 * Created by navinash on 14/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumCoinChange {

    public int coinChangeBottomUp(final int[] coins, final int total) {
        if (total == 0 || coins == null || coins.length == 0) {
            return 0;
        }

        final int[][] dp = new int[coins.length][total + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }

        for (int j = 1; j <= total; j++) {
            if (coins[0] <= j && dp[0][j - coins[0]] != Integer.MAX_VALUE) {
                dp[0][j] = 1 + dp[0][j - coins[0]];
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                final int include;
                if (j >= coins[i]) {
                    include = dp[i][j - coins[i]];
                } else {
                    include = Integer.MAX_VALUE;
                }
                if (include != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + include);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[coins.length - 1][total] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[coins.length - 1][total];
    }

    public int coinChangeTopDown(final int[] coins, final int total) {
        if (total == 0 || coins == null || coins.length == 0) {
            return 0;
        }

        final Integer[][] dp = new Integer[coins.length][total + 1];
        final int minCoin = _coinChangeTopDown(coins, total, 0, dp);
        if (minCoin == Integer.MAX_VALUE) {
            return -1;
        }
        return minCoin;
    }


    public int coinChangeRecursive(final int[] coins, final int total) {
        if (total == 0 || coins == null || coins.length == 0) {
            return 0;
        }

        final int minCoin = _coinChangeRecursive(coins, total, 0);
        if (minCoin == Integer.MAX_VALUE) {
            return -1;
        }
        return minCoin;
    }

    private int _coinChangeTopDown(int[] coins, int total, int index, Integer[][] dp) {
        if (total == 0) {
            return 0;
        }
        if (index >= coins.length || total < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][total] == null) {
            int include = coins[index] <= total ? _coinChangeTopDown(coins, total - coins[index], index, dp) : Integer.MAX_VALUE;
            if (include != Integer.MAX_VALUE) {
                include = 1 + include;
            }
            final int exclude = _coinChangeRecursive(coins, total, index + 1);
            dp[index][total] = Math.min(include, exclude);
        }
        return dp[index][total];
    }

    private int _coinChangeRecursive(int[] coins, int total, int index) {
        if (total == 0) {
            return 0;
        }
        if (index >= coins.length || total < 0) {
            return Integer.MAX_VALUE;
        }
        int include = coins[index] <= total ? _coinChangeRecursive(coins, total - coins[index], index) : Integer.MAX_VALUE;
        if (include != Integer.MAX_VALUE) {
            include = 1 + include;
        }
        final int exclude = _coinChangeRecursive(coins, total, index + 1);
        return Math.min(include, exclude);
    }
}
