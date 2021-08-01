package com.avi.practice.company.google;

/**
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * Example 2:
 * <p>
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 * <p>
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 0 <= limit <= 109
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public int longestSubarray(int[] nums, int limit) {
       return longestSubarray_Deque(nums, limit);
    }

    public int longestSubarray_Deque(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int n = nums.length;
        if (n == 1) {
            return 1;
        }
        final MaxSegmentTree maxTree = new MaxSegmentTree(nums);
        final MinSegmentTree minTree = new MinSegmentTree(nums);
        int left = 0;
        int right = 1;

        int result = 1;

        while (right < n) {
            final int max = maxTree.query(left, right);
            final int min = minTree.query(left, right);
            if (Math.abs(max - min) <= limit) {
                if (right - left + 1 > result) {
                    result = (right - left + 1);
                }
                right++;
            } else {
                left++;
            }
        }
        return result;
    }

    public int longestSubarray_SegmentTree(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int n = nums.length;
        if (n == 1) {
            return 1;
        }
        final MaxSegmentTree maxTree = new MaxSegmentTree(nums);
        final MinSegmentTree minTree = new MinSegmentTree(nums);
        int left = 0;
        int right = 1;

        int result = 1;

        while (right < n) {
            final int max = maxTree.query(left, right);
            final int min = minTree.query(left, right);
            if (Math.abs(max - min) <= limit) {
                if (right - left + 1 > result) {
                    result = (right - left + 1);
                }
                right++;
            } else {
                left++;
            }
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
            return _query(0, n - 1, 0, qStart, qEnd);
        }

        private int _query(int start, int end, int segmentIndex, int qStart, int qEnd) {
            // full overlap
            if (qStart <= start && qEnd >= end) {
                return this.st[segmentIndex];
            }

            // no overlap;
            if (qStart > end || qEnd < start) {
                return Integer.MIN_VALUE;
            }
            final int mid = start + (end - start) / 2;
            final int left = _query(start, mid, 2 * segmentIndex + 1, qStart, qEnd);
            final int right = _query(mid + 1, end, 2 * segmentIndex + 2, qStart, qEnd);
            return Math.max(left, right);
        }
    }

    private static final class MinSegmentTree {
        private final int[] arr;
        private final int n;
        private final int[] st;

        private MinSegmentTree(final int[] arr) {
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
            this.st[segmentIndex] = Math.min(this.st[2 * segmentIndex + 1], this.st[2 * segmentIndex + 2]);
        }

        private int query(final int qStart, final int qEnd) {
            return _query(0, n - 1, 0, qStart, qEnd);
        }

        private int _query(int start, int end, int segmentIndex, int qStart, int qEnd) {
            // full overlap
            if (qStart <= start && qEnd >= end) {
                return this.st[segmentIndex];
            }

            // no overlap;
            if (qStart > end || qEnd < start) {
                return Integer.MAX_VALUE;
            }
            final int mid = start + (end - start) / 2;
            final int left = _query(start, mid, 2 * segmentIndex + 1, qStart, qEnd);
            final int right = _query(mid + 1, end, 2 * segmentIndex + 2, qStart, qEnd);
            return Math.min(left, right);
        }
    }

}
