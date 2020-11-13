package com.avi.educative.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Knapsack01Test {

    private static final Knapsack01 solver = new Knapsack01();

    @Test
    public void maxProfitRecursive() {
        {
            final int[] profits = {1, 6, 10, 16};
            final int[] weights = {1, 2, 3, 5};
            final int capacity = 7;
            final int expected = 22;
            final int actual = solver.maxProfitRecursive(weights, profits, capacity);
            Assert.assertEquals(expected, actual);
        }
        {
            final int[] profits = {1, 6, 10, 16};
            final int[] weights = {1, 2, 3, 5};
            final int capacity = 6;
            final int expected = 17;
            final int actual = solver.maxProfitRecursive(weights, profits, capacity);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void maxProfitDP() {
        {
            final int[] profits = {1, 6, 10, 16};
            final int[] weights = {1, 2, 3, 5};
            final int capacity = 7;
            final int expected = 22;
            final int actual = solver.maxProfitDP(weights, profits, capacity);
            Assert.assertEquals(expected, actual);
        }
        {
            final int[] profits = {1, 6, 10, 16};
            final int[] weights = {1, 2, 3, 5};
            final int capacity = 6;
            final int expected = 17;
            final int actual = solver.maxProfitDP(weights, profits, capacity);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void maxProfitDPImproved() {
        {
            final int[] profits = {1, 6, 10, 16};
            final int[] weights = {1, 2, 3, 5};
            final int capacity = 7;
            final int expected = 22;
            final int actual = solver.maxProfitDP(weights, profits, capacity);
            Assert.assertEquals(expected, actual);
        }
        {
            final int[] profits = {1, 6, 10, 16};
            final int[] weights = {1, 2, 3, 5};
            final int capacity = 6;
            final int expected = 17;
            final int actual = solver.maxProfitDP(weights, profits, capacity);
            Assert.assertEquals(expected, actual);
        }
    }
}