package com.avi.practice.arrays;

import com.avi.educative.tree.FenwickTree;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class InversionCount {

    public static int inversionCount(final int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (final int a : arr) {
            if (a >= max) {
                max = a;
            }
        }

        final int[] newArr = new int[max + 1];
        final FenwickTree tree = new FenwickTree(newArr, false);
        int inversionCount = 0;
        for (final int a : arr) {
            inversionCount += tree.sum(max) - tree.sum(a);
            tree.update(a, 1);
        }
        return inversionCount;
    }
}
