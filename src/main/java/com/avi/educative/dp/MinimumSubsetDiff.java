package com.avi.educative.dp;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumSubsetDiff {

    public int minSubsetDiffBottomUp(final int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int sum = 0;
        for (final int a : num) {
            sum += a;
        }
        final boolean[][] dp = new boolean[num.length][(sum / 2) + 1];
        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum / 2; j++) {
            dp[0][j] = num[0] == j;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j <= sum/2; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j >= num[i]) {
                    dp[i][j] = dp[i - 1][j - num[i]];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // find the max sum which is possible
        int max = Integer.MIN_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[num.length - 1][j]) {
                max = j;
                break;
            }
        }
        return Math.abs(sum - max - max);
    }

    public int minSubsetDiffTopDown(final int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int sum = 0;
        for (final int a : num) {
            sum += a;
        }
        final Integer[][] dp = new Integer[num.length][sum + 1];
        return _minSubsetDiffTopDown(num, 0, 0, 0, dp);
    }

    private int _minSubsetDiffTopDown(int[] num, int index, int sum1, int sum2, Integer[][] dp) {
        if (index == num.length) {
            return Math.abs(sum1 - sum2);
        }
        if (dp[index][sum1] == null) {
            final int diff1 = _minSubsetDiffTopDown(num, index + 1, sum1 + num[index], sum2, dp);
            final int diff2 = _minSubsetDiffTopDown(num, index + 1, sum1, sum2 + num[index], dp);
            dp[index][sum1] = Math.min(diff1, diff2);
        }
        return dp[index][sum1];
    }

    public int minSubsetDiffRecursive(final int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        return _minSubsetDiffRecursive(num, 0, 0, 0);
    }

    private int _minSubsetDiffRecursive(int[] num, int index, int sum1, int sum2) {
        if (index == num.length) {
            return Math.abs(sum1 - sum2);
        }

        final int diff1 = _minSubsetDiffRecursive(num, index + 1, sum1 + num[index], sum2);
        final int diff2 = _minSubsetDiffRecursive(num, index + 1, sum1, sum2 + num[index]);
        return Math.min(diff1, diff2);
    }
}
