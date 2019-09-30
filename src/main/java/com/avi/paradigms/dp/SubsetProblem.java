package com.avi.paradigms.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.avi.practice.utils.CommonUtils.isEmpty;

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
        this.n = isEmpty(a) ? 0 : a.length;
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
     * Time:  O(m * n)
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

    /**
     * Time:  O(n * n)
     * Space: O(n)
     */
    final int maxSubsetDivisiblePairs() {
        Arrays.sort(a);
        final int[] dp = new int[n];
        dp[n - 1] = 1;
        int overallMax = 0;
        for (int i = n - 2; i >= 0; i--) {
            int currMax = 0;
            for (int j = i + 1; j < n; j++) {
                if (a[j] % a[i] == 0) {
                    currMax = Math.max(currMax, dp[j]);
                }
                dp[i] = 1 + currMax;
                if (overallMax < dp[i]) {
                    overallMax = dp[i];
                }
            }
        }
        return overallMax;
    }


    final Result subsetsSum(final int sum) {
        if (n == 0) {
            return null;
        }
        final Result[][] dp = new Result[n + 1][sum + 1];
        // 0 elements any sum -> not possible
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = emptyFalseResult();
        }
        // any elements 0 sum -> always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = emptyTrueResult();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                final int element = a[i - 1];
                if (j >= a[i - 1]) {
                    if (dp[i - 1][j].found || dp[i - 1][j - a[i - 1]].found) {
                        final Result result = new Result();
                        result.found = true;
                        if (dp[i - 1][j].found) {
                            final Set<Set<Integer>> oldSets = isEmpty(dp[i - 1][j].subsets) ? new HashSet<>() : new HashSet<>(dp[i - 1][j].subsets);
                            result.subsets.addAll(_getNewSets(oldSets, element));
                        }
                        if (dp[i - 1][j - a[i - 1]].found) {
                            final Set<Set<Integer>> oldSets = isEmpty(dp[i - 1][j - a[i - 1]].subsets) ? new HashSet<>() : new HashSet<>(dp[i - 1][j - a[i - 1]].subsets);
                            result.subsets.addAll(_getNewSets(oldSets, element));
                        }
                        dp[i][j] = result;
                    } else {
                        dp[i][j] = emptyFalseResult();
                    }
                } else {
                    final Result result = new Result();
                    if (dp[i - 1][j].found) {
                        result.found = true;
                        final Set<Set<Integer>> oldSets = isEmpty(dp[i - 1][j].subsets) ? new HashSet<>() : new HashSet<>(dp[i - 1][j].subsets);
                        result.subsets.addAll(_getNewSets(oldSets, element));
                        dp[i][j] = result;
                    } else {
                        dp[i][j] = emptyFalseResult();
                    }
                }
            }
        }
        return dp[n][sum];
    }

    private Set<Set<Integer>> _getNewSets(final Set<Set<Integer>> oldSubsets, final int element) {
        final Set<Set<Integer>> newSubsets = new HashSet<>();
        final Set<Integer> newSet = new HashSet<>();
        newSet.add(element);
        if (isEmpty(oldSubsets)) {
            newSubsets.add(newSet);
        } else {
            for (final Set<Integer> subset : oldSubsets) {
                subset.addAll(newSet);
                newSubsets.add(newSet);
            }
        }
        return newSubsets;
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

    static final class Result {
        boolean found;
        final Set<Set<Integer>> subsets = new HashSet<>();

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Sum exists: ").append(found).append('\n');
            for (final Set<Integer> subset : subsets) {
                sb.append(subset).append('\n');
            }
            return sb.toString();
        }
    }

    Result emptyFalseResult() {
        final Result r = new Result();
        r.found = false;
        return r;
    }

    Result emptyTrueResult() {
        final Result r = new Result();
        r.found = true;
        return r;
    }
}
