package com.avi.educative.tree;

import java.util.Arrays;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FenwickTree {
    private final int[] bit;
    private final int n;
    private final int[] arr;

    public FenwickTree(int[] arr) {
        this(arr, true);
    }

    public FenwickTree(int[] arr, boolean initialize) {
        this.arr = arr;
        this.n = arr.length;
        this.bit = new int[n + 1]; // 1-indexed
        Arrays.fill(bit, 0);
        if (initialize) {
            for (int i = 0; i < n; i++) {
                update(i, arr[i]);
            }
        }
    }

    public void update(int index, int value) {
        // Assuming caller is using 0 based indexing so update index by 1 first
        index++;
        for (int i = index; i <= n; i += (i & (-i))) {
            bit[i] += value;
        }
    }

    public int sum(int index) {
        // Assuming caller is using 0 based indexing so update index by 1 first
        index++;
        int sum = 0;
        for (int i = index; i > 0; i -= (i & (-i))) {
            sum += bit[i];
        }
        return sum;
    }
}
