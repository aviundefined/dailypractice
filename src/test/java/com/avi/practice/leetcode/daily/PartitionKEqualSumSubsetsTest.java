package com.avi.practice.leetcode.daily;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 30/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionKEqualSumSubsetsTest {

    @Test
    public void canPartitionKSubsets1() {
        final PartitionKEqualSumSubsets solver = new PartitionKEqualSumSubsets();
        final int[] nums = {4, 3, 2, 3, 5, 2, 1};
        final int k = 4;
        final boolean expected = true;
        final boolean actual = solver.canPartitionKSubsets(nums, k);
        Assert.assertEquals(expected, actual);
    }

}