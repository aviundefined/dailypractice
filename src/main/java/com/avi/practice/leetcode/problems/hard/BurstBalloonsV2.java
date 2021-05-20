package com.avi.practice.leetcode.problems.hard;

/**
 * Created by navinash on 20/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BurstBalloonsV2 {

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        final int n = nums.length;
        final int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    final int left = i == k ? 0 : dp[i][k - 1];
                    final int right = j == k ? 0 : dp[k + 1][j];
                    final int value = (i == 0 ? 1 : nums[i - 1]) * nums[k] * (j == n - 1 ? 1 : nums[j + 1]);
                    final int currentTotal = left + right + value;
                    if (currentTotal > max) {
                        max = currentTotal;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
    }
}
