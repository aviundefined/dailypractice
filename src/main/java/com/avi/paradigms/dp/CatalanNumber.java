package com.avi.paradigms.dp;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class CatalanNumber {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    final int catalan(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        final int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            int c = 0;
            for (int j = 0; j <= i - 1; j++) {
                c = c + (catalan[j] * catalan[i - 1 - j]);
            }
            catalan[i] = c;
        }
        return catalan[n];
    }
}
