package com.avi.paradigms.bitmanipulation;

import java.util.Arrays;

/**
 * Created by navinash on 29/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinXor {

    public int minXor(final int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        Arrays.sort(nums);
        // a <= b <= c then
        // a ^ b <= a ^ c
        //       or
        // b ^ c <= a ^ c
        // that means xor of consecutive numbers will be less
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] ^ nums[i]) < min) {
                min = nums[i - 1] ^ nums[i];
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
