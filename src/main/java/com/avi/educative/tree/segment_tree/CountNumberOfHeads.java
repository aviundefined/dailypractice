package com.avi.educative.tree.segment_tree;

import java.util.Arrays;

/**
 * Created by navinash on 01/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountNumberOfHeads {

    private final int n;
    private final int[] arr;
    private final int[] st;

    public CountNumberOfHeads(final int[] arr) {
        // 1 -> head, 0 -> tail
        this.arr = arr;
        this.n = arr.length;
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
        this.st[segmentTreeIndex] = this.st[2 * segmentTreeIndex + 1] + this.st[2 * segmentTreeIndex + 2];
    }

    public int numHeads(final int qStart, final int qEnd) {
        return numHeads(qStart, qEnd, 0, n - 1, 0);
    }

    private int numHeads(
            final int qStart,
            final int qEnd,
            final int start,
            final int end,
            final int segmentTreeIndex) {
        // complete overlap
        if (qStart <= start && qEnd >= end) {
            return this.st[segmentTreeIndex];
        }

        // no overlap
        if (qEnd < start || qStart > end) {
            return 0;
        }

        final int mid = start + (end - start) / 2;
        final int left = numHeads(qStart, qEnd, start, mid, 2 * segmentTreeIndex + 1);
        final int right = numHeads(qStart, qEnd, start, mid, 2 * segmentTreeIndex + 1);
        return left + right;
    }

    public void flip(final int index) {
        flip(0, n - 1, 0, index);
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("st: " + Arrays.toString(st));
    }

    private void flip(int start, int end, int segmentTreeIndex, int index) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            if (this.arr[index] == 0) {
                this.st[segmentTreeIndex]++;
                this.arr[index] = 1;
            } else {
                this.st[segmentTreeIndex]--;
                this.arr[index] = 0;
            }
            return;
        }

        final int mid = start + (end - start) / 2;
        if (index < mid) {
            flip(start, mid, 2 * segmentTreeIndex + 1, index);
        } else {
            flip(mid + 1, end, 2 * segmentTreeIndex + 2, index);
        }

        this.st[segmentTreeIndex] = this.st[2 * segmentTreeIndex + 1] + this.st[2 * segmentTreeIndex + 2];
    }
}
