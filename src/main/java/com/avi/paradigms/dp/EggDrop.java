package com.avi.paradigms.dp;

/**
 * Created by navinash on 24/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class EggDrop {

    /**
     * Time:  O(eggs * floors * floors)
     * Space:  O(eggs * floors)
     */
    final int solve(final int eggs, final int floors) {
        final int[][] c = new int[eggs + 1][floors + 1];
        for (int i = 0; i <= eggs; i++) {
            c[i][0] = 0; // 0 floors to 0 attempts
            c[i][1] = 1;  // 1 floors to 1 attempt
        }
        for (int j = 1; j <= floors; j++) {
            c[1][j] = j; // if any 1 egg j floors to j attempts
        }
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                c[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    final int currMax = 1 + Math.max(c[i - 1][k - 1], c[i][j - k]);
                    // currMax is less than c[i][j] update c[i[[j]
                    if (currMax < c[i][j]) {
                        c[i][j] = currMax;
                    }
                }
            }
        }
        return c[eggs][floors];
    }
}
