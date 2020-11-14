package com.avi.educative.dp;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UnboundedKnapsack {

    public int maxProfitBottomUp(final int[] weights, final int[] profits, final int capacity) {
        if (profits.length == 0 || weights.length != profits.length || capacity == 0) {
            return 0;
        }

        final int[][] dp = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= capacity; j++) {
            if (weights[0] <= j) {
                dp[0][j] = profits[0] + dp[0][j - weights[0]];
            }
        }
        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                final int include;
                if (weights[i] <= j) {
                    include = profits[i] + dp[i][j - weights[i]];
                } else {
                    include = 0;
                }
                dp[i][j] = Math.max(dp[i - 1][j], include);
            }
        }
        return dp[weights.length - 1][capacity];
    }

    public int maxProfitDPTopDown(final int[] weights, final int[] profits, final int capacity) {
        if (profits.length == 0 || weights.length != profits.length || capacity == 0) {
            return 0;
        }
        final Integer[][] dp = new Integer[weights.length][capacity + 1];
        return _maxProfitDPTopDown(weights, profits, capacity, 0, dp);
    }

    private int _maxProfitDPTopDown(int[] weights, int[] profits, int capacity, int index, Integer[][] dp) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }

        if (dp[index][capacity] == null) {
            final int include = weights[index] <= capacity ?
                    profits[index] + _maxProfitDPTopDown(weights, profits, capacity - weights[index], index, dp) : 0;
            final int exclude = _maxProfitDPTopDown(weights, profits, capacity, index + 1, dp);
            dp[index][capacity] = Math.max(include, exclude);
        }
        return dp[index][capacity];
    }

    public int maxProfitRecursive(final int[] weights, final int[] profits, final int capacity) {
        if (profits.length == 0 || weights.length != profits.length || capacity == 0) {
            return 0;
        }

        return _maxProfitRecursive(weights, profits, capacity, 0);
    }

    private int _maxProfitRecursive(int[] weights, int[] profits, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }

        final int include = weights[index] <= capacity ?
                profits[index] + _maxProfitRecursive(weights, profits, capacity - weights[index], index) : 0;
        final int exclude = _maxProfitRecursive(weights, profits, capacity, index + 1);
        return Math.max(include, exclude);
    }
}
