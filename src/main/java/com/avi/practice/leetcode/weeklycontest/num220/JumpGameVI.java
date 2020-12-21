package com.avi.practice.leetcode.weeklycontest.num220;

/**
 * Created by navinash on 21/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You are given a 0-indexed integer array nums and an integer k.
 * <p>
 * You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
 * <p>
 * You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.
 * <p>
 * Return the maximum score you can get.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,-1,-2,4,-7,3], k = 2
 * Output: 7
 * Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
 * Example 2:
 * <p>
 * Input: nums = [10,-5,-2,4,0,3], k = 3
 * Output: 17
 * Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
 * Example 3:
 * <p>
 * Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length, k <= 105
 * -104 <= nums[i] <= 104
 */
public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        // f(j] = nums[j] + max(f(j-i)) where i is in [1,k]
        final int[] f = new int[nums.length];
        int lastMax = -1;
        f[0] = nums[0];
        f[1] = nums[0] + nums[1];
        for (int j = 2; j < nums.length; j++) {
            int max = Integer.MIN_VALUE;
            if (lastMax == -1 || j - lastMax > k) {
                for (int i = 1; i <= k; i++) {
                    if (j - i >= 0 && max < f[j - i]) {
                        max = f[j - i];
                        lastMax = j - i;
                    }
                }
            } else {
                for (int i = lastMax; i <= j; i++) {
                    if (i >= 0 && max < f[i]) {
                        max = f[i];
                        lastMax = i;
                    }
                }
            }

            f[j] = nums[j] + max;
        }
        return f[nums.length - 1];
    }
}
