package com.avi.practice.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 21/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        final int n = nums.length;
        if (n == 0) {
            return k == 0 ? 1 : 0;
        }

        if (n == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int count = 0;
        final Map<Integer, Integer> sumsByFreq = new HashMap<>();
        sumsByFreq.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += sumsByFreq.getOrDefault(sum - k, 0);
            sumsByFreq.compute(sum, (s, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        return count;
    }
}
