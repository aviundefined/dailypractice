package com.avi.practice.leetcode.daily;

/**
 * Created by navinash on 30/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        int idx = 0;
        int patchCount = 0;
        long miss = 1L;

        while (miss <= n) {
            if (idx < nums.length && nums[idx] <= miss) {
                miss += nums[idx];
                idx++;
            } else {
                miss += miss;
                patchCount++;
            }
        }
        return patchCount;
    }
}
