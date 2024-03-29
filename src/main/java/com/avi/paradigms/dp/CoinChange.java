package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

import java.util.Arrays;

/**
 * Created by navinash on 24/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class CoinChange {
    private final int[] coins;
    private final int m;

    CoinChange(int[] coins) {
        this.coins = coins;
        this.m = CommonUtils.isEmpty(coins) ? 0 : this.coins.length;
    }

    /**
     * Time: O(coins * sum)
     * Space: O(coins * sum)
     */
    final int change(final int sum) {
        final int[][] change = new int[m + 1][sum + 1];
        // if sum = 0, then always have one solution
        for (int i = 0; i <= m; i++) {
            change[i][0] = 1;
        }

        // if coins 0 and sum > 1 then 0 solution
        for (int j = 1; j <= sum; j++) {
            change[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                change[i][j] = change[i - 1][j] + (j >= coins[i - 1] ? change[i][j - coins[i - 1]] : 0);
            }
        }
        return change[m][sum];
    }

    /**
     * Time:  O(coins * sum)
     * Space: O(sum)
     */
    final int minNumberOfCoinsForChange(final int sum) {
        if (sum == 0) {
            return 0;
        }
        final int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < m; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]);
                }
            }
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i] = 1 + dp[i];
            }
        }
        return dp[sum];
    }
}
