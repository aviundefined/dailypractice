package com.avi.educative.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UnboundedKnapsackTest {
    private static final UnboundedKnapsack ks = new UnboundedKnapsack();

    @Test
    public void maxProfitBottomUp() {
        {
            final int[] profits = {15, 50, 60, 90};
            final int[] weights = {1, 3, 4, 5};
            final int capacity = 8;
            final int expected = 140;
            CommonUtils.printArr(weights);
            CommonUtils.printArr(profits);
            final int actual = ks.maxProfitBottomUp(weights, profits, capacity);
            Assert.assertEquals(String.valueOf(capacity), expected, actual);
            System.out.println("-----------------");
        }
    }

    @Test
    public void maxProfitDPTopDown() {
        {
            final int[] profits = {15, 50, 60, 90};
            final int[] weights = {1, 3, 4, 5};
            final int capacity = 8;
            final int expected = 140;
            CommonUtils.printArr(weights);
            CommonUtils.printArr(profits);
            final int actual = ks.maxProfitDPTopDown(weights, profits, capacity);
            Assert.assertEquals(String.valueOf(capacity), expected, actual);
            System.out.println("-----------------");
        }
    }

    @Test
    public void maxProfitRecursive() {
        {
            final int[] profits = {15, 50, 60, 90};
            final int[] weights = {1, 3, 4, 5};
            final int capacity = 8;
            final int expected = 140;
            CommonUtils.printArr(weights);
            CommonUtils.printArr(profits);
            final int actual = ks.maxProfitRecursive(weights, profits, capacity);
            Assert.assertEquals(String.valueOf(capacity), expected, actual);
            System.out.println("-----------------");
        }
    }
}