package com.avi.practice.leetcode.random;

/**
 * Created by navinash on 15/04/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReduceToOneType1 {

    // n -> n -> 1
    // if n % 2 == 0 -> n/2
    // if n % 3 == 0 -> n/3

    public int minSteps(final int n) {
        if(n <= 1 ) {
            return 0;
        }

        if(n <= 3 ) {
            return 1;
        }

        final Integer[] dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        return recursion(n, dp);
    }

    private int recursion(int n, Integer[] dp) {
        if(n <= 1 ) {
            return 0;
        }

        if(n <= 3 ) {
            return 1;
        }

        if(dp[n] != null) {
            return dp[n];
        }

        final int x = recursion(n - 1, dp);
        final int y = n % 2 == 0 ? recursion(n /2, dp) : Integer.MAX_VALUE;
        final int z = n % 3 == 0 ? recursion(n / 3, dp) : Integer.MAX_VALUE;
        dp[n] = 1 + Math.min(Math.min(x, y), z);
        return dp[n];
    }
}
