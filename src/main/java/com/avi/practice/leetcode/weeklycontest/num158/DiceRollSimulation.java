package com.avi.practice.leetcode.weeklycontest.num158;

/**
 * Created by navinash on 23/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DiceRollSimulation {

    public int dieSimulator(int n, int[] rollMax) {
        long[][] dp = new long[n][7];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1; // one dice so answer is 1
        }
        dp[0][6] = 6; // last row to store sum
        for (int i = 1; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                dp[i][j] = dp[i - 1][6]; // without constraints
                if (i - rollMax[j] < 0) { // j can be consecutive like dice roll is 3 but 4 consecutive allowed so no constraint
                    sum = (sum + dp[i][j]);
                } else {
                    if (i - rollMax[j] - 1 >= 0) {
                        // dice roll is 4 and 2 consecutive j allowed then from remove ways from 1st dice roll where j
                        dp[i][j] = (dp[i][j] - (dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j]));
                    } else {
                        // i = 4 allowed 4
                        dp[i][j] = (dp[i][j] - 1);
                    }
                    sum = (sum + dp[i][j]);
                }

            }
            dp[i][6] = sum;
        }
        return (int) (dp[n - 1][6]);
    }
}
