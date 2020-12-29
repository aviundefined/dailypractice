package com.avi.paradigms.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 29/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxXor {

    public int maxXor(final int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int mask = 0;
        int max = 0;
        for (int bit = 31; bit >= 0; bit--) {
            final Set<Integer> prefixes = new HashSet<>();
            mask = mask | (1 << bit);
            for (final int num : nums) {
                prefixes.add(num & mask);
            }
            final int tmp = max | (1 << bit);
            for (final int prefix : prefixes) {
                if (prefixes.contains((prefix ^ tmp))) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
