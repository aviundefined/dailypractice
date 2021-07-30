package com.avi.pepcoding.dp.classes;

/**
 * Created by navinash on 29/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Fibonacci {

    private Integer[] memo;

    public int fib(final int n) {
        memo = new Integer[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    public int fib_Tabulization(final int n) {
        final int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i  = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i-1];
        }
        return dp[n];
    }
}
