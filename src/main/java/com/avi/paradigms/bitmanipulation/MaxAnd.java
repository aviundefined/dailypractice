package com.avi.paradigms.bitmanipulation;

/**
 * Created by navinash on 29/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxAnd {

    public int maxAnd(final int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int max = 0;
        for (int bit = 31; bit >= 0; bit--) {
            final int tmp = max | (1 << bit);
            final int count = count(tmp, nums);
            if (count >= 2) {
                max = tmp;
            }
        }
        return max;
    }

    private int count(final int pattern, final int[] nums) {
        int count = 0;
        for (final int num : nums) {
            if ((pattern & num) == pattern) {
                count++;
            }
        }
        return count;
    }
}
