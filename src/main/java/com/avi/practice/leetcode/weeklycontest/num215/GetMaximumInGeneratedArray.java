package com.avi.practice.leetcode.weeklycontest.num215;

/**
 * Created by navinash on 08/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * <p>
 * You are given an integer n. An array nums of length n + 1 is generated in the following way:
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * nums[2 * i] = nums[i] when 2 <= 2 * i <= n
 * nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
 * Return the maximum integer in the array nums​​​.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 7
 * Output: 3
 * Explanation: According to the given rules:
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is 3.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 1
 * Explanation: According to the given rules, the maximum between nums[0], nums[1], and nums[2] is 1.
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: 2
 * Explanation: According to the given rules, the maximum between nums[0], nums[1], nums[2], and nums[3] is 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 100
 */
public class GetMaximumInGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        final int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        int max = 1;
        for (int i = 3; i <= n; i++) {
            final int j = i / 2;
            if (i % 2 == 0) {
                dp[i] = dp[j];
            } else {
                dp[i] = dp[j] + dp[j + 1];
            }
            if (max <= dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
