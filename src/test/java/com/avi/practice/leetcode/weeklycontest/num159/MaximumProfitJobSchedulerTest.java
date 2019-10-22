package com.avi.practice.leetcode.weeklycontest.num159;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumProfitJobSchedulerTest {

    @Test
    public void jobScheduling() {
        final MaximumProfitJobScheduler solver = new MaximumProfitJobScheduler();
        {
            final int[] startTime = {1, 2, 3, 3};
            final int[] endTime = {3, 4, 5, 6};
            final int[] profit = {50, 10, 40, 70};
            final int expected = 120;
            final int maxProfit = solver.jobScheduling(startTime, endTime, profit);
            Assert.assertEquals(expected, maxProfit);
        }
        {
            final int[] startTime = {1, 2, 3, 4, 6};
            final int[] endTime = {3, 5, 10, 6, 9};
            final int[] profit = {20, 20, 100, 70, 60};
            final int expected = 150;
            final int maxProfit = solver.jobScheduling(startTime, endTime, profit);
            Assert.assertEquals(expected, maxProfit);
        }
        {
            final int[] startTime = {1, 1, 1};
            final int[] endTime = {2, 3, 4};
            final int[] profit = {5, 6, 4};
            final int expected = 6;
            final int maxProfit = solver.jobScheduling(startTime, endTime, profit);
            Assert.assertEquals(expected, maxProfit);
        }
    }
}