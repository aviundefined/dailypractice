package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

import java.util.Arrays;

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

    /**
     * Time:  O(n * sum)
     * Space: O(n * sum)
     */
    final int countSubSetForGivenSum(final int sum) {
        return _count(sum)[n][sum];
    }

    /**
     * Time:  O(n * sum(a))
     * Space: O(n * sum(a))
     */
    final int countDivisibleByM(final int m) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        final int[][] count = _count(sum);
        int numCount = 0;
        for (int j = 1; j <= sum; j++) {
            if (count[n][j] > 0 && j % m == 0) {
                numCount += count[n][j];
            }
        }
        return numCount;
    }

    /**
     * Time:  O(m*m*n)
     * Space: O(m)
     */
    final boolean isDivisibleByMSumExists(final int m) {
        if (n > m) {
            return true;
        }
        // keep track of all the modulo seen so far using subset sum
        final boolean[] dp = new boolean[m];
        for (int i = 0; i < n; i++) {
            final boolean[] tmp = new boolean[m];
            // obvious case: if only consider current element as subset : a[i] then a[i] % m = true;
            tmp[a[i] % m] = true;
            // create temp modulo array for current element
            for (int j = 0; j < m; j++) {
                if (dp[j]) {
                    final int newMod = (j + a[i]) % m;
                    // if not seen so far
                    if (!dp[newMod] && !tmp[newMod]) {
                        // update in tmp
                        tmp[newMod] = true;
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                if (tmp[j] && !dp[j]) {
                    dp[j] = true;
                }
            }
            if (dp[0]) {
                return true;
            }
        }
        return dp[0];
    }

    private int[][] _count(final int sum) {
        final int[][] count = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(count[i], 0);
        }
        // 0 elements and zon zero sum, not possible so 0a
        for (int j = 1; j <= sum; j++) {
            count[0][j] = 0;
        }
        // any elements but 0 zero, always have 1 way, don't include it
        for (int i = 0; i <= n; i++) {
            count[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= a[i - 1]) {
                    count[i][j] = count[i - 1][j] + count[i - 1][j - a[i - 1]];
                } else {
                    count[i][j] = count[i - 1][j];
                }
            }
        }
//        CommonUtils.printMatrix(count);
        return count;
    }
}
