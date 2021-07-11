package com.avi.practice.company.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 06/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FirstMissingNumber {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        final Set<Integer> seen = new HashSet<>();
        int max = Integer.MIN_VALUE;
        // set of candidates
        for(final int num : nums) {
            if(num > 1) {
                seen.add(num);
            }
        }
        return -1;
    }
}
