package com.avi.educative.dp;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionSubset {

    public boolean canPartitionDPBottomUp(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int sum = 0;
        for (final int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0) {
            return false;
        }
        final boolean[][] dp = new boolean[arr.length][sum / 2 + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum / 2; i++) {
            dp[0][i] = arr[0] == sum;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                boolean include = false;
                if (arr[i] <= j) {
                    include = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = include || dp[i - 1][j];
            }
        }
        return dp[arr.length - 1][sum / 2];
    }

    public boolean canPartitionDPMemoization(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int sum = 0;
        for (final int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0) {
            return false;
        }
        final Boolean[][] dp = new Boolean[arr.length][sum / 2 + 1];
        return _canPartitionDPMemoization(arr, sum / 2, 0, dp);

    }

    private boolean _canPartitionDPMemoization(int[] arr, int sum, int index, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (index >= arr.length || sum < 0) {
            return false;
        }

        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        if (arr[index] <= sum) {
            if (_canPartitionDPMemoization(arr, sum - arr[index], index + 1, dp)) {
                dp[index][sum] = true;
                return dp[index][sum];
            }
        }
        dp[index][sum] = _canPartitionDPMemoization(arr, sum, index + 1, dp);
        return dp[index][sum];

    }
}
