package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 25/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 * <p>
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 * Example 3:
 * <p>
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= m <= min(50, nums.length)
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < m) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (final int a : nums) {
            max += a;
            if (a < min) {
                min = a;
            }
        }
        int curr = max;
        while (min < max) {
            final int mid = min + (max - min) / 2;
            if (isPossibleSimple(nums, m, mid)) {
                if (mid < curr) {
                    curr = mid;
                }
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return curr;
    }

    final boolean isPossible(int[] nums, int m, int sum) {
        int l = -1;
        final int n = nums.length;
        int numSubArrays = 0;
        while (l < n - 1) {
            int curSum = 0;
            for (int r = l + 1; r < n; r++) {
                if (nums[r] + curSum <= sum) {
                    curSum = nums[r] + curSum;
                    l = r;
                } else {
                    break;
                }
            }
            if (curSum <= sum) {
                numSubArrays++;
            }
            if (numSubArrays > m) {
                return false;
            }
        }
        return numSubArrays <= m;
    }

    final boolean isPossibleSimple(final int[] nums, final int m, final int sum) {
        int numSubArrays = 0;
        int currSum = 0;
        for (int num : nums) {
            if (num > sum) {
                return false;
            }
            if (currSum + num <= sum) {
                currSum += num;
            } else {
                currSum = num;
                numSubArrays++;
            }
        }

        return numSubArrays + 1 <= m;
    }
}
