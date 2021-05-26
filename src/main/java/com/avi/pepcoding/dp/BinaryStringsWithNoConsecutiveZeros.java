package com.avi.pepcoding.dp;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BinaryStringsWithNoConsecutiveZeros {

    public int nums(final int n) {
        if (n <= 1) {
            return n;
        }

        // let's say f(i, 0) is the function which stores number of binary strings of i length ending with 0.
        // Example:
        //      i = 1 -> (0)
        //      i = 2 -> (10)
        //      i = 3 -> (010, 110)
        // let's say f(i, 1) is the function which stores number of binary strings of i length ending with 1.
        // Example:
        //      i = 1 -> (1)
        //      i = 2 -> (11, 01)
        //      i = 3 -> (111, 011, 101)

        // now if want to calculate f(i+1, 0) then that means wants number of binary strings of (i+1) length ending at 0
        // so we can't add 0 in the nd of i length strings ending at 0, but we can simply add 0 at then end of all the strings of i length ending at 1
        // so f(i+1, 0) = f(i, 1)

        // similarly, if want to calculate f(i+1, 1) then that means wants number of binary strings of (i+1) length ending at 1
        // so we can simply add 1 in the end of both types of binary string i.e. binary strings of i length ending at 0 and 1
        // so f(i+1, 0) = f(i,1) + f(i,0)

        final int[][] f = new int[n + 1][2];
        f[0][0] = 0;
        f[1][0] = 0;
        f[1][0] = 1;
        f[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i][0] = f[i - 1][1];
            f[i][1] = f[i - 1][1] + f[i - 1][0];
        }
        return f[n][0] + f[n][1];
    }
}
