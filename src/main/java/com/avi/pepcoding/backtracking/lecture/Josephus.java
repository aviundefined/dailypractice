package com.avi.pepcoding.backtracking.lecture;

/**
 * Created by navinash on 23/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Josephus {

    public int survive(final int n, final int k) {
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
