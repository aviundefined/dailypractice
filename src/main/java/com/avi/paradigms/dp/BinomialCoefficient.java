package com.avi.paradigms.dp;

/**
 * Created by navinash on 23/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class BinomialCoefficient {

    final int nCk(final int n, final int k) {
        if (k > n) {
            throw new RuntimeException("k {" + k + "} should be less than n {" + n + "}");
        }
        if (n == 0 || k == 0 || n == k) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        final int[][] c = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            c[i][0] = 1;
            c[i][1] = i;
        }
        c[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
        return c[n][k];
    }
}
