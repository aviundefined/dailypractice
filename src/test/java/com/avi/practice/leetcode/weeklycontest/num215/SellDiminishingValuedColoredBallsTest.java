package com.avi.practice.leetcode.weeklycontest.num215;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 09/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SellDiminishingValuedColoredBallsTest {

    private final SellDiminishingValuedColoredBalls solver = new SellDiminishingValuedColoredBalls();
    @Test
    public void maxProfit() {
        {
            final int[] inventory = {2,5};
            int orders = 4;
            final int expected = 14;
            CommonUtils.printArr(inventory);
            final int actual = solver.maxProfit(inventory, orders);
             System.out.printf("For Orders [%d]: expected: [%d], actual: [%d]%n", orders, expected, actual);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------------");
        }
        {
            final int[] inventory = {3,5};
            int orders = 6;
            final int expected = 19;
            CommonUtils.printArr(inventory);
            final int actual = solver.maxProfit(inventory, orders);
            System.out.printf("For Orders [%d]: expected: [%d], actual: [%d]%n", orders, expected, actual);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------------");
        }
        {
            final int[] inventory = {2,8,4,10,6};
            int orders = 20;
            final int expected = 110;
            CommonUtils.printArr(inventory);
            final int actual = solver.maxProfit(inventory, orders);
             System.out.printf("For Orders [%d]: expected: [%d], actual: [%d]%n", orders, expected, actual);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------------");
        }

        {
            final int[] inventory = {1000000000};
            int orders = 1000000000;
            final int expected = 21;
            CommonUtils.printArr(inventory);
            final int actual = solver.maxProfit(inventory, orders);
             System.out.printf("For Orders [%d]: expected: [%d], actual: [%d]%n", orders, expected, actual);
            Assert.assertEquals(expected, actual);
            System.out.println("--------------------------------");
        }
    }
}