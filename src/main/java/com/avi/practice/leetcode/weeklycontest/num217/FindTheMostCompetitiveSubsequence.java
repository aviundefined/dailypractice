package com.avi.practice.leetcode.weeklycontest.num217;

import java.util.Stack;

/**
 * Created by navinash on 30/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindTheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        final Stack<Integer> s = new Stack<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[i] < s.peek() && s.size() - 1 + n - i >= k) {
                s.pop();
            }
            if (s.size() <= k - 1) {
                s.push(nums[i]);
            }
        }

        final int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = s.pop();
        }
        return result;
    }
}
