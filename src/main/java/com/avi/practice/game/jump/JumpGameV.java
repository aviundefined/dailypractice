package com.avi.practice.game.jump;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGameV {
    public int maxJumps(int[] arr, int d) {
        final int n = arr.length;
        final Integer[] dp = new Integer[n];
        int max = 1;
        for(int i = 0; i < arr.length; i++) {
            // start from i node and see how many nodes can be visited
            // maintain max node count
            final int count = dfs(i, d, arr, dp);
            if(count > max) {
                max = count;
            }
        }
        return max;
    }

    private int dfs(
            final int i,
            final int d,
            final int[] arr,
            final Integer[] dp) {

        if(i >= arr.length || i < 0) {
            return 0;
        }
        if(dp[i] != null) {
            return dp[i];
        }

        int count = 0;
        for(int j = i + 1; j <= i + d && j < arr.length; j++) {
            if(arr[i] <= arr[j]) {
                break;
            }
            count = Math.max(count, dfs(j, d, arr, dp));
        }
        for(int j = i - 1; j >= i - d && j >= 0; j--) {
            if(arr[i] <= arr[j]) {
                break;
            }
            count = Math.max(count, dfs(j, d, arr, dp));
        }
        dp[i] = count + 1;
        return dp[i];
    }
}
