package com.avi.educative.tree.segment_tree;

import java.util.Arrays;

/**
 * Created by navinash on 01/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SegmentTreeMax {

    private final int n;
    private final int[] arr;
    private final int[] st;

    public SegmentTreeMax(final int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        this.st = new int[4 * n];
        build(0, n - 1, 0);
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("st: " + Arrays.toString(st));
    }

    private void build(int start, int end, int segmentTreeIndex) {

        if (start == end) {
            this.st[segmentTreeIndex] = this.arr[start];
            return;
        }

        final int mid = start + (end - start) / 2;

        build(start, mid, 2 * segmentTreeIndex + 1);
        build(mid + 1, end, 2 * segmentTreeIndex + 2);

        st[segmentTreeIndex] = Math.max(st[2 * segmentTreeIndex + 1], st[2 * segmentTreeIndex + 2]);
    }

    public final int getMax(final int qStart, final int qEnd) {
        return getMax(qStart, qEnd, 0, n - 1, 0);
    }

    public final void update(final int index, final int value) {
        update(0, n - 1, 0, index, value);
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("st: " + Arrays.toString(st));
    }

    private int getMax(int qStart, int qEnd, int start, int end, int segmentTreeIndex) {
        // complete overlap
        if (qStart <= start && qEnd >= end) {
            return st[segmentTreeIndex];
        }

        // no overlap
        if (qStart > end || qEnd < start) {
            return Integer.MIN_VALUE;
        }

        final int mid = start + (end - start) / 2;
        final int left = getMax(qStart, qEnd, start, mid, 2 * segmentTreeIndex + 1);
        final int right = getMax(qStart, qEnd, mid + 1, end, 2 * segmentTreeIndex + 2);
        return Math.max(left, right);
    }

    private void update(int start, int end, int segmentTreeIndex, int index, int value) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            this.arr[index] = value;
            this.st[segmentTreeIndex] = value;
            return;
        }

        final int mid = start + (end - start) / 2;
        if (index <= mid) {
            update(start, mid, 2 * segmentTreeIndex + 1, index, value);
        } else {
            update(mid + 1, end, 2 * segmentTreeIndex + 2, index, value);
        }
        this.st[segmentTreeIndex] = Math.max(st[2 * segmentTreeIndex + 1], st[2 * segmentTreeIndex + 2]);
    }
}
