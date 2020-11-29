package com.avi.practice.company.microsoft.interviewbit;

import java.util.List;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumSumContiguousArray {

    public int maxSubArray(final List<Integer> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        if (A.size() == 1) {
            return A.get(0);
        }
        final int[] dp = new int[A.size()];
        int max = A.get(0);
        dp[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            // inclued last sum
            final int includePrevSum = dp[i - 1] + A.get(i);
            if (includePrevSum >= A.get(i)) {
                dp[i] = includePrevSum;
            } else {
                dp[i] = A.get(i);
            }
            if (dp[i] >= max) {
                max = dp[i];
            }
        }
        return max;
    }
}
