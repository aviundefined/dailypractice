package com.avi.practice.game.jump;

/**
 * Created by navinash on 25/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JumpGameV {
    private MinSegmentTree tree;
    public int maxJumps(int[] arr, int d) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        tree = new MinSegmentTree(arr);
        int max = Integer.MIN_VALUE;
        final int n = arr.length;
        for (int i = 0; i < n; i++) {
            final boolean[] visited  = new boolean[n];
            int count = dfs(i, d, visited);
            if(count > max) {
                max = count;
            }
        }
        return max;
    }

    private int dfs(int i, int d, boolean[] visited) {
        visited[i] = true;
        // from i we can go to [i + 1, i +d]
        return 0;
    }

    private static final class MinSegmentTree {
        private final int[] arr;
        private final int[] st;
        private final int n;

        private MinSegmentTree(final int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            this.st = new int[4 * n];
            build(0, n - 1, 0);
        }

        private void build(int start, int end, int segmentIndex) {
            if (start == end) {
                st[segmentIndex] = arr[start];
                return;
            }

            final int mid = start + (end - start) / 2;
            build(start, mid, 2 * segmentIndex + 1);
            build(mid + 1, end, 2 * segmentIndex + 2);
            arr[segmentIndex] = Math.min(arr[2 * segmentIndex + 1], arr[2 * segmentIndex + 2]);
        }

        private int query(final int qStart, final int qEnd) {
            return query(qStart, qEnd, 0, n - 1, 0);
        }

        private int query(int qStart, int qEnd, int start, int end, int segmentIndex) {
            // complete overlap
            if (qStart >= start && qEnd <= end) {
                return this.st[segmentIndex];
            }
            // no overlap
            if (qStart > end || qEnd < start) {
                return Integer.MAX_VALUE;
            }
            final int mid = start + (end - start) / 2;
            final int left = query(qStart, qEnd, start, mid, 2 * segmentIndex + 1);
            final int right = query(qStart, qEnd, mid + 1, end, 2 * segmentIndex + 2);
            return Math.max(left, right);
        }
    }
}
