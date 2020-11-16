package com.avi.practice.leetcode.weeklycontest.num215;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 16/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 * <p>
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 * <p>
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 */
public class MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        if (nums == null || nums.length == 0 || x == 0) {
            return 0;
        }
        final int n = nums.length;
        final Map<Integer, Integer> leftSumMap = new HashMap<>();
        int leftSum = 0;
        leftSumMap.put(leftSum, -1);
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            if (leftSum <= x) {
                leftSumMap.put(leftSum, i);
                continue;
            }
            break;
        }
        int rightSum = 0;
        final Map<Integer, Integer> rightSumMap = new HashMap<>();
        rightSumMap.put(rightSum, n);
        for (int i = n - 1; i >= 0; i--) {
            rightSum += nums[i];
            if (rightSum <= x) {
                rightSumMap.put(rightSum, i);
                continue;
            }
            break;
        }

        int min = Integer.MAX_VALUE;
        for (final Map.Entry<Integer, Integer> e : leftSumMap.entrySet()) {
            if (rightSumMap.containsKey(x - e.getKey())) {
                final int left = e.getValue();
                final int right = rightSumMap.get(x - e.getKey());
                if (left < right && min > (left + 1 + n - right)) {
                    min = (left + 1 + n - right);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


}
