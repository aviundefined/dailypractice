package com.avi.practice.leetcode.weeklycontest.num219;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumHeightByStackingCuboids {

    public int maxHeight(final int[][] cuboids) {
        // First sort the cuboid
        for (final int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (o1, o2) -> {
            if (o2[0] != o1[0]) {
                return o2[0] - o1[0];
            }
            if (o2[1] != o1[1]) {
                return o2[1] - o1[1];
            }
            return o2[2] - o1[2];
        });
        for (final int[] cuboid : cuboids) {
            System.out.println(Arrays.toString(cuboid));
        }
        final int n = cuboids.length;
        final int[] dp = new int[n];
        int maxHeight = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            dp[j] = cuboids[j][2];
            for (int i = 0; i < j; i++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[j] = Math.max(dp[j], dp[i] + cuboids[j][2]);
                }
            }
            if (dp[j] > maxHeight) {
                maxHeight = dp[j];
            }
        }
        return maxHeight;
    }

    public int[] twoSum(int[] nums, int target) {
        final ValueWithIndex[] values = new ValueWithIndex[nums.length];
        for(int i = 0; i < nums.length; i++) {
            values[i] = new ValueWithIndex(nums[i], i);
        }

        Arrays.sort(values, Comparator.comparingInt(o -> o.val));

        return null;
    }

    private static final class ValueWithIndex {
        private int val;
        private int index;

        private ValueWithIndex(final int val, final int index) {
            this.val = val;
            this.index = index;
        }
    }
}
