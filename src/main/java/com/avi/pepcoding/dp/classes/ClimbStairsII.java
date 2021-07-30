package com.avi.pepcoding.dp.classes;

import java.util.Arrays;

/**
 * Created by navinash on 29/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ClimbStairsII {

    public int dp(final int[] arr, final int n) {
        final int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >=0; i--) {
            for(int j = 1; j <= arr[i] && j + i <= n; j++) {
                dp[i] += dp[j + i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

}
