package com.avi.practice.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 30/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionKEqualSumSubsets {

    private final Map<String, Boolean> dp = new HashMap<>();
    private int[] arr;
    private int k;
    private int targetSum;
    private boolean[] visited;

    public boolean canPartitionKSubsets(int[] arr, int k) {
        this.arr = arr;
        this.k = k;

        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        this.targetSum = totalArraySum / k;
        this.visited = new boolean[n];

        return backtrack(0, 0, 0);
    }

    private boolean backtrack(int index, int count, int currSum) {

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }
        final String key = key(visited);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            final boolean curr = backtrack(0, count + 1, 0);
            dp.put(key, curr);
            return curr;
        }

        // Try not picked elements to make some combinations.
        for (int i = index; i < this.arr.length; ++i) {
            if (!visited[i]) {
                // Include this element in current subset.
                visited[i] = true;

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(i + 1, count, currSum + arr[i])) {
                    return true;
                }

                // Backtrack step.
                visited[i] = false;
            }
        }

        dp.put(key, false);
        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private String key(final boolean[] visited) {
        final StringBuilder sb = new StringBuilder();
        for (final boolean curr : visited) {
            if (curr) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }

}
