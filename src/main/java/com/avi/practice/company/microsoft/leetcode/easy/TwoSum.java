package com.avi.practice.company.microsoft.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> indexbyValues = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int rem = target - nums[i];
            final Integer j = indexbyValues.get(rem);
            if (j != null) {
                return i > j ? new int[]{j, i} : new int[]{i, j};
            }
            indexbyValues.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSumBinarySearch(int[] nums, int target) {
        final ValueWithIndex[] values = new ValueWithIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = new ValueWithIndex(nums[i], i);
        }
        Arrays.sort(values, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < values.length - 1; i++) {
            final int rem = target - values[i].val;
            final int j = binarySearch(rem, values, i + 1);
            if (j != -1) {
                return new int[]{values[i].index, j};
            }
        }
        return null;
    }

    private static final class ValueWithIndex {
        private final int val;
        private final int index;

        private ValueWithIndex(final int val, final int index) {
            this.val = val;
            this.index = index;
        }
    }

    private int binarySearch(final int target, final ValueWithIndex[] values, int left) {
        int right = values.length - 1;

        while (left <= right) {
            final int mid = left + (right - left) / 2;
            if (values[mid].val == target) {
                return values[mid].index;
            }
            if (values[mid].val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
