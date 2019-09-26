package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 22/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class UglyNumber {

    /**
     * Time:  O(n)
     * Space: O(n)
     */
    final int uglyNumber(final int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        final int[] d = new int[n];
        d[0] = 1; // first ugly number
        int nextM2 = d[0] * 2;
        int nextM3 = d[0] * 3;
        int nextM5 = d[0] * 5;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            final int nextUgly = Math.min(Math.min(nextM2, nextM3), nextM5);
            d[i] = nextUgly;
            if (nextUgly == nextM2) {
                i2++;
                nextM2 = d[i2] * 2;
            }
            if (nextUgly == nextM3) {
                i3++;
                nextM3 = d[i3] * 3;
            }
            if (nextUgly == nextM5) {
                i5++;
                nextM5 = d[i5] * 5;
            }
        }
        CommonUtils.printArr(d);
        return d[n - 1];
    }
}
