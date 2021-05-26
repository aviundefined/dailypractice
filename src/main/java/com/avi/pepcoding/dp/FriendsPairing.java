package com.avi.pepcoding.dp;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FriendsPairing {

    public int pairs(final int n) {
        if (n <= 2) {
            return n;
        }

        // if there are n friends, we want to pair those
        // so let's say if nth friend wants to be alone always then in that case, all the options in which (n-1) friends can be paired it will be same to that
        // if nth friend always want to pair up with someone so he has (n-1) options so that will be equal to (n-1) * f(n-2)
        // so f(n) = f(n-1) + (n-1)*f(n-2);

        final int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + (i - 1) * f[i - 2];
        }
        return f[n];
    }
}
