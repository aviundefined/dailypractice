package com.avi.practice.leetcode.problems.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 20/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BurstBalloonsV2Test {
    private static final BurstBalloonsV2 solver = new BurstBalloonsV2();

    @Test
    public void maxCoins() {
        {
            final int[] nums =  {3,1,5,8};
            final int expected = 167;
            final int actual = solver.maxCoins(nums);
            Assert.assertEquals(Arrays.toString(nums), expected, actual);
        }
    }
}