package com.avi.educative.tree;

import java.util.Arrays;

/**
 * Created by navinash on 01/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SegmentTreeRangeSum {

    private final int[] st;
    private final int[] arr;
    private final int n;

    public SegmentTreeRangeSum(final int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        this.st = new int[4 * n];
        build(arr, st, 0, n - 1, 0);
        System.out.println("Arr: " + Arrays.toString(arr));
        System.out.println("Segment Tree: " + Arrays.toString(st));
    }

    private void build(int[] arr, int[] st, int start, int end, int segmentTreeIdx) {

        if (start == end) {
            st[segmentTreeIdx] = arr[start];
            return;
        }

        final int middle = start + (end - start) / 2;
        build(arr, st, start, middle, 2 * segmentTreeIdx + 1);
        build(arr, st, middle + 1, end, 2 * segmentTreeIdx + 2);
        st[segmentTreeIdx] = st[2 * segmentTreeIdx + 1] + st[2 * segmentTreeIdx + 2];

    }

    public int getRangeSum(final int qStart, final int qEnd) {
        return getRangeSum(qStart, qEnd, 0, n - 1, 0);
    }

    private int getRangeSum(int qStart, int qEnd, int start, int end, int segmentTreeIndex) {
        // complete overlap
        if (qStart <= start && qEnd >= end) {
            return st[segmentTreeIndex];
        }
        // no overlap
        if (qStart > end || qEnd < start) {
            return 0;
        }

        final int mid = start + (end - start) / 2;
        final int left = getRangeSum(qStart, qEnd, start, mid, 2 * segmentTreeIndex + 1);
        final int right = getRangeSum(qStart, qEnd, mid + 1, end, 2 * segmentTreeIndex + 2);
        return left + right;
    }

    public void update(int index, int value) {
        update(0, n - 1, 0, index, value);
        System.out.println("Arr: " + Arrays.toString(arr));
        System.out.println("Segment Tree: " + Arrays.toString(st));
    }

    private void update(int start, int end, int currSegmentTreeIndex, int index, int value) {


        if (start == end) {
            this.arr[index] = value;
            this.st[currSegmentTreeIndex] = value;
            return;
        }

        final int middle = start + (end - start) / 2;
        if (index <= middle) {
            // go left
            update(start, middle, 2 * currSegmentTreeIndex + 1, index, value);
        } else {
            // go right
            update(middle + 1, end, 2 * currSegmentTreeIndex + 2, index, value);
        }
        st[currSegmentTreeIndex] = st[2 * currSegmentTreeIndex + 1] + st[2 * currSegmentTreeIndex + 2];
    }

}
