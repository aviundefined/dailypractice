package com.avi.educative.dp;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Knapsack01 {

    public int maxProfitDPImproved(final int[] weights, final int[] profits, final int capacity) {
        if (weights == null || profits == null || capacity <= 0) {
            return 0;
        }
        final int[] dp = new int[capacity + 1];
        dp[0] = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                final int includingIth = weights[i] <= j ? (profits[i] + dp[j - weights[i]]) : 0;
                dp[j] = Math.max(includingIth, dp[j - 1]);
            }
        }
        return dp[capacity];
    }

    public int maxProfitDP(final int[] weights, final int[] profits, final int capacity) {
        if (weights == null || profits == null || capacity <= 0) {
            return 0;
        }

        final int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= weights.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int includingIth = 0;
                if (weights[i - 1] <= j) {
                    includingIth = profits[i - 1] + dp[i - 1][j - weights[i - 1]];
                }
                dp[i][j] = Math.max(includingIth, dp[i - 1][j]);
            }
        }
        return dp[weights.length][capacity];
    }

    public int maxProfitRecursive(final int[] weights, final int[] profits, final int capacity) {
        if (weights == null || profits == null || capacity <= 0) {
            return 0;
        }

        return _maxProfitRecursive(weights, profits, capacity, 0);
    }

    private int _maxProfitRecursive(int[] weights, int[] profits, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }

        final int includingCurrent = weights[index] <= capacity ?
                profits[index] + _maxProfitRecursive(weights, profits, capacity - weights[index], index + 1) : 0;
        final int excludingCurrent = _maxProfitRecursive(weights, profits, capacity, index + 1);
        return Math.max(includingCurrent, excludingCurrent);
    }

}
