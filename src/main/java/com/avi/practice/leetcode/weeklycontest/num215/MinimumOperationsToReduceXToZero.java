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
        int min = Integer.MAX_VALUE;
        final int n = nums.length;
        final Map<Integer, State> states = new HashMap<>();
        int left = -1;

        int leftSum = 0;
        while (left < n - 1) {
            leftSum = leftSum + (left == -1 ? 0 : nums[left]);
            int remainingSum = x - leftSum;
            if (remainingSum == 0) {
                final State state = new State(left, -1);
                states.put(remainingSum, state);
                if (min > state.length(n)) {
                    min = state.length(n);
                }
            } else if (remainingSum > 0) {
                int lastRightIndex = -1;
                for (int i = n - 1; i > left && i >= 0; i--) {
                    remainingSum -= nums[i];
                    if (remainingSum == 0) {
                        lastRightIndex = i;
                        break;
                    }
                    if (remainingSum < 0) {
                        break;
                    }
                }

                if (lastRightIndex != -1) {
                    final State state = new State(left, lastRightIndex);
                    states.put(remainingSum, state);
                    if (min > state.length(n)) {
                        min = state.length(n);
                    }
                }
            } else {
                break;
            }
            left++;
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private static final class State {
        private final int left;
        private final int right;

        public State(int left, int right) {
            this.left = left;
            this.right = right;
        }

        private int length(final int n) {
            final int leftLen = left == -1 ? 0 : left + 1;
            final int rightLen = right == -1 ? 0 : n - right;
            return leftLen + rightLen;
        }

    }
}
