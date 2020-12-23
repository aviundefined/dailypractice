package com.avi.practice.company.atlassian;

/**
 * Created by navinash on 22/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MajorityElement {

    public final int majorityElement(final int[] nums) {
        final Integer candidate = findCandidate(nums);
        if (isMajorityElement(nums, candidate)) {
            return candidate;
        }
        return -1;
    }

    private boolean isMajorityElement(int[] nums, int candidate) {
        int count = 0;
        for (final int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > (nums.length / 2);
    }

    private Integer findCandidate(final int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (final int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num ? 1 : -1);
        }
        return candidate;
    }
}
