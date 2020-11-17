package com.avi.educative.dp;

import java.util.Arrays;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EggDrop {

    int attempts(final int eggs, final int floor) {
        if (floor == 0) {
            return 0;
        }

        if (eggs == 1) {
            return floor;
        }

        if (floor == 1) {
            return 1;
        }

        final int[][] dp = new int[eggs + 1][floor + 1];
        for (int i = 0; i <= eggs; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        // 0 floor -> always 0
        // 1 floor -> always 1
        for (int i = 1; i <= eggs; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        // 0 egg -> Integer MAX
        // 1 egg -> num floor
        for (int j = 1; j <= floor; j++) {
            dp[0][j] = Integer.MAX_VALUE;
            dp[1][j] = j;
        }
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floor; j++) {
                for (int k = 1; k <= j; k++) {
                    // drop egg from kth floor if egg is broken then i - 1 eggs and k -1 floors remaining
                    // if egg is not broken then i eggs and j - k floors remaining
                    int eggBroken = Integer.MAX_VALUE;
                    if (dp[i - 1][k - 1] != Integer.MAX_VALUE) {
                        eggBroken = dp[i - 1][k - 1];
                    }

                    int eggNotBroken = Integer.MAX_VALUE;
                    if (dp[i][j - k] != Integer.MAX_VALUE) {
                        eggNotBroken = dp[i][j - k];
                    }
                    final int max = Math.max(eggBroken, eggNotBroken);
                    if (max != Integer.MAX_VALUE && max < dp[i][j]) {
                        dp[i][j] = 1 + max;
                    }
                }
            }
        }
        return dp[eggs][floor];
    }
}
