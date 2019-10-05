package com.avi.paradigms.dp;

import java.util.Arrays;

/**
 * Created by navinash on 05/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class CountUniqueBinarySearchTrees {

    int count(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // Lets define a function F(n) to represent the unique number of BSTs
        // For that we need a helper function G(i, n) i.e number of BSTs where i is start node and n is total number of nodes
        // Then F(n) = G(1,n) + G(2,n) + G(3,n) ...... + G(n-2, n) + G(n-1, n) + G(n,n)
        // Further G(n) = F(i - 1) * F(n-i)
        // Base cases for n = 0, 1, for n = 1, 1
        final int[] f = new int[n + 1];
        Arrays.fill(f, 0);
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] = f[i] + (f[j - 1] * f[i - j]);
            }
        }
        return f[n];
    }
}
