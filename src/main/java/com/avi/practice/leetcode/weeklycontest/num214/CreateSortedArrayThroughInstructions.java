package com.avi.practice.leetcode.weeklycontest.num214;

import com.avi.educative.tree.FenwickTree;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CreateSortedArrayThroughInstructions {

    public int createSortedArray(int[] instructions) {
        if(instructions == null || instructions.length <= 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (final int a : instructions) {
            if (a >= max) {
                max = a;
            }
        }

        final int[] newArr = new int[max +1];
        final FenwickTree tree = new FenwickTree(newArr);
        long cost = 0;
        for(final int a : instructions) {
            final long numMin = tree.sum(a - 1);
            final long numMax = tree.sum(max) - tree.sum(a);
            cost += Math.min(numMin, numMax);
            tree.update(a, 1);
        }
        return (int) (cost % 1000_000_007);
    }
}
