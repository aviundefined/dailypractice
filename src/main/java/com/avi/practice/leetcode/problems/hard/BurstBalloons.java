package com.avi.practice.leetcode.problems.hard;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        final int n = nums.length;
        final int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = left(nums, i) * nums[i] * right(nums, i);
        }
        // dp[i][j] = for k in [i,] max(nums[i-1] * nums[k] * nums[j+1] + dp[i][k-1] + dp[j][k+1])
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                final int j = i + len - 1;
                if (j >= n) {
                    break;
                }
                final int left = left(nums, i);
                final int right = right(nums, j);
                for (int k = i; k <= j; k++) {
                    int cur = left * nums[k] * right;
                    cur += (k == i ? 0 : dp[i][k - 1]);
                    cur += (k == j ? 0 : dp[k + 1][j]);
                    if (cur > dp[i][j]) {
                        dp[i][j] = cur;
                    }
                }
            }
        }
        CommonUtils.printMatrix(dp);
        return dp[0][n - 1];
    }

    private static int left(final int[] nums, final int index) {
        if (index <= 0) {
            return 1;
        }
        return nums[index - 1];
    }


    private static int right(final int[] nums, final int index) {
        if (index >= nums.length - 1) {
            return 1;
        }
        return nums[index + 1];
    }
}
