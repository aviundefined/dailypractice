package com.avi.pepcoding.dp;

/**
 * Created by navinash on 23/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumSumSquare {

    public  int getMinSumSquares(int num) {
        if(num <= 0) {
            return num;
        }

        final int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= num; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i ; j++) {
                int rem = i - (j * j);
                dp[i] = Math.min(1 + dp[rem], dp[i]);
            }
        }
        return dp[num];
    }
}
