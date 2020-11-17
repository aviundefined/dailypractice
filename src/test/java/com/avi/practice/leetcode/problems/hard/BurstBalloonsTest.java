package com.avi.practice.leetcode.problems.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BurstBalloonsTest {

    private static final BurstBalloons solver = new BurstBalloons();
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