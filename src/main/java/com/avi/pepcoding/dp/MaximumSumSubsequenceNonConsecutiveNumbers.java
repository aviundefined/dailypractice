package com.avi.pepcoding.dp;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumSumSubsequenceNonConsecutiveNumbers {

    public int maxSum(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int include = nums[0];
        int exclude = 0;
        for (int i = 1; i < nums.length; i++) {
            final int newInclude = exclude + nums[i];
            final int newExclude = Math.max(include, exclude);
            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include, exclude);
    }
}
