package com.avi.pepcoding.backtracking;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Josephus {

    public final int survive(final int n, final int k) {
        // 3
        // 0 1 2 3 4
        // 3 4 0 1 -> 0 1 2 3  -> (x + k) % n
        if (k == 1) {
            return n;
        }
        if (n == 1) {
            return 0;
        }
        final int x = survive(n - 1, k);
        return (x + k) % n;
    }
}
