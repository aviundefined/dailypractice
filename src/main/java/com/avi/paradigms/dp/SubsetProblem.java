package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 26/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class SubsetProblem {

    private final int[] a;
    private final int n;

    SubsetProblem(int[] a) {
        this.a = a;
        this.n = CommonUtils.isEmpty(a) ? 0 : a.length;
    }

    /**
     * Time:  O(n * sum)
     * Space: O(n * sum)
     */
    final boolean isSolutionExists(final int sum) {
        final boolean[][] dp = new boolean[n + 1][sum + 1];
        // no elements in array, solution doesn't exist
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        // if sum is 0 then solution exists
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // if current sum is equal to or greater than the element at i -1 position then
                //  - solution can be found with including i -1 element and reducing the sum
                //  - also excluding the i - 1 element
                // else only way is also excluding the i - 1 element
                if (j >= a[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
/*
        for (boolean[] rows : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print((rows[j] ? 1 : 0) + " ");
            }
            System.out.println();
        }*/
        System.out.println();
        return dp[n][sum];
    }
}
