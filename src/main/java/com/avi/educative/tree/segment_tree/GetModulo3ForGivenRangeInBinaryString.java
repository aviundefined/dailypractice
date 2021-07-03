package com.avi.educative.tree.segment_tree;

import java.util.Arrays;

/**
 * Created by navinash on 02/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GetModulo3ForGivenRangeInBinaryString {

    private final int n;
    private final int[] st;
    private final int[] arr;

    public GetModulo3ForGivenRangeInBinaryString(final String binaryString) {
        this.n = binaryString.length();
        this.st = new int[4 * n];
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            this.arr[i] = binaryString.charAt(i) - '0';
        }
        build(0, n - 1, 0);
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("st: " + Arrays.toString(st));
    }

    private void build(int start, int end, int segmentTreeIndex) {
        if (start == end) {
            // leaf
            this.st[segmentTreeIndex] = this.arr[start];
            return;
        }

        final int mid = start + (end - start) / 2;
        build(start, mid, 2 * segmentTreeIndex + 1);
        build(mid + 1, end, 2 * segmentTreeIndex + 2);
        final int pow = (int) Math.pow(2, (end - mid));
        this.st[segmentTreeIndex] = this.st[2 * segmentTreeIndex + 1] * pow + this.st[2 * segmentTreeIndex + 2];
    }

    public final int getModulo3(final int qStart, final int qEnd) {
        return getModulo3(qStart, qEnd, 0, n - 1, 0) % 3;
    }

    private int getModulo3(int qStart, int qEnd, int start, int end, int segmentTreeIndex) {
        // complete overlap
        if (qStart <= start && qEnd >= end) {
            return this.st[segmentTreeIndex];
        }

        // no overlap
        if (qStart > end || qEnd < start) {
            return 0;
        }
        final int mid = start + (end - start) / 2;
        final int left = getModulo3(qStart, qEnd, start, mid, 2 * segmentTreeIndex + 1);
        final int right = getModulo3(qStart, qEnd, mid + 1, end, 2 * segmentTreeIndex + 2);
        final int pow = (int) Math.pow(2, (end - mid));
        return left  + right;
    }
}
