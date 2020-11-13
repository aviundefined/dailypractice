package com.avi.educative.dp;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountSubsetSum {

    public int countSubsetsRecursive(int[] num, int sum) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        return _countSubsetsRecursive(num, sum, 0);
    }

    public int countSubsetsTopDown(int[] num, int sum) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }

        final Integer[][] dp = new Integer[num.length][sum + 1];
        return _countSubsetsTopDown(num, sum, 0, dp);
    }


    public int countSubsetsBottomUp(int[] num, int sum) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        final int[][] dp = new int[num.length][sum + 1];
        for (int i = 0; i < num.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= sum; j++) {
            dp[0][j] = num[0] == j ? 1 : 0;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num[i]) {
                    dp[i][j] += dp[i - 1][j - num[i]];
                }
            }
        }
        return dp[num.length - 1][sum];
    }

    private int _countSubsetsTopDown(int[] num, int sum, int index, Integer[][] dp) {
        if (sum == 0) {
            return 1;
        }

        if (index >= num.length || sum < 0) {
            return 0;
        }

        if (dp[index][sum] == null) {
            final int include = num[index] <= sum ? _countSubsetsTopDown(num, sum - num[index], index + 1, dp) : 0;
            final int exclude = _countSubsetsTopDown(num, sum, index + 1, dp);
            dp[index][sum] = include + exclude;
        }
        return dp[index][sum];
    }

    private int _countSubsetsRecursive(int[] num, int sum, int index) {
        if (sum == 0) {
            return 1;
        }
        if (index >= num.length || sum < 0) {
            return 0;
        }

        final int include;
        if (num[index] <= sum) {
            include = _countSubsetsRecursive(num, sum - num[index], index + 1);
        } else {
            include = 0;
        }

        final int exclude = _countSubsetsRecursive(num, sum, index + 1);
        return include + exclude;
    }
}
