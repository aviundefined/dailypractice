package com.avi.practice.leetcode.monthly.august2021;

/**
 * Created by navinash on 08/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        final int n = s.length();
        if (n == 1) {
            return 0;
        }
        return dp_optimized(s);
    }

    private int dp_optimized(final String s) {
        final int n = s.length();
        final boolean[][] isPalindrome = isPalindromeDP(s);
        final int[] dp = new int[n];
        dp[0] = 0;
        for (int j = 1; j < n; j++) {
            if (isPalindrome[0][j]) {
                dp[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = j; i >= 1; i--) {
                    if (isPalindrome[i][j]) {
                        min = Math.min(min, dp[i - 1]);
                    }
                }
                dp[j] = min + 1;
            }
        }
        return dp[n - 1];
    }


    public int naiveDP_TLE(String s) {
        // first attempting n^3 solution
        if (s == null || s.length() == 0) {
            return 0;
        }
        final int n = s.length();
        if (n == 1) {
            return 0;
        }
        final boolean[][] isPalindrome = isPalindromeDP(s);

        final int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 0;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                } else {
                    if (isPalindrome[i][j]) {
                        dp[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            final int curr = dp[i][k] + dp[k + 1][j];
                            min = Math.min(min, curr);
                        }
                        dp[i][j] = 1 + min;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    private boolean[][] isPalindromeDP(final String s) {
        final int n = s.length();
        final boolean[][] isPalindrome = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    isPalindrome[i][j] = true;
                } else if (gap == 1) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
                }
            }
        }
        return isPalindrome;
    }
}
