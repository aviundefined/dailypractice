package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by navinash on 17/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindow_UsingHeap(nums, k);
    }

    public int[] maxSlidingWindow_Deque(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[]{};
        }

        if (k == 1) {
            return nums;
        }

        final int[] result = new int[nums.length - k + 1];
        final Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) {
                q.removeLast();
            }
            q.addLast(new int[]{i, nums[i]});
        }
        result[0] = q.getFirst()[1];

        for (int i = k, j = 1; i < nums.length; i++, j++) {
            // expire from first
            if (!q.isEmpty() && i - q.peekFirst()[0] >= k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) {
                q.removeLast();
            }
            q.addLast(new int[]{i, nums[i]});
            result[j] = q.getFirst()[1];
        }
        return result;
    }

    public int[] maxSlidingWindow_UsingHeap(final int[] nums, final int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[]{};
        }

        if (k == 1) {
            return nums;
        }

        final int[] result = new int[nums.length - k + 1];
        final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        q.offer(new int[]{0, nums[0]});
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && q.peek()[1] < nums[i]) {
                q.poll();
            }
            q.offer(new int[]{i, nums[i]});
        }
        result[0] = q.peek()[1];

        for (int i = k, j = 1; i < nums.length; i++, j++) {
            // expire from heap
            while (!q.isEmpty() && i - q.peek()[0] >= k) {
                q.poll();
            }
            // now remove all element less than current
            while (!q.isEmpty() && q.peek()[1] < nums[i]) {
                q.poll();
            }
            q.offer(new int[]{i, nums[i]});
            result[j] = q.peek()[1];
        }
        return result;
    }


    private int[] maxSlidingWindow_SegmentTree(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[]{};
        }
        final MaxSegmentTree tree = new MaxSegmentTree(nums);
        final int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            final int end = i + k - 1;
            result[i] = tree.query(i, end);
        }
        return result;
    }

    private static final class MaxSegmentTree {

        private final int[] arr;
        private final int n;
        private final int[] st;

        private MaxSegmentTree(final int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            this.st = new int[4 * n];
            build(0, n - 1, 0);
        }

        private void build(int start, int end, int segmentIndex) {
            if (start == end) {
                this.st[segmentIndex] = this.arr[start];
                return;
            }
            final int mid = start + (end - start) / 2;
            build(start, mid, 2 * segmentIndex + 1);
            build(mid + 1, end, 2 * segmentIndex + 2);
            this.st[segmentIndex] = Math.max(this.st[2 * segmentIndex + 1], this.st[2 * segmentIndex + 2]);
        }

        private int query(final int qStart, final int qEnd) {
            return query(qStart, qEnd, 0, n - 1, 0);
        }

        private int query(int qStart, int qEnd, int start, int end, int segmentIndex) {
            // complete overlap
            if (qStart <= start && qEnd >= end) {
                return this.st[segmentIndex];
            }

            // no overlap
            if (qStart > end || qEnd < start) {
                return Integer.MIN_VALUE;
            }
            final int mid = start + (end - start) / 2;
            final int left = query(qStart, qEnd, start, mid, 2 * segmentIndex + 1);
            final int right = query(qStart, qEnd, mid + 1, end, 2 * segmentIndex + 2);
            return Math.max(left, right);
        }
    }
}
