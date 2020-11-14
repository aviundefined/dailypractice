package com.avi.educative.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 14/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumCoinChangeTest {

    private static final MinimumCoinChange cc = new MinimumCoinChange();

    @Test
    public void coinChangeBottomUp() {
        {
            final int[] denominations = {1, 2, 3};
            final int total = 5;
            final int expected = 2;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeBottomUp(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {1, 2, 3};
            final int total = 11;
            final int expected = 4;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeBottomUp(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {1, 2, 3};
            final int total = 7;
            final int expected = 3;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeBottomUp(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {3, 5};
            final int total = 7;
            final int expected = -1;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeBottomUp(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
    }

    @Test
    public void coinChangeTopDown() {
        {
            final int[] denominations = {1, 2, 3};
            final int total = 5;
            final int expected = 2;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeTopDown(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {1, 2, 3};
            final int total = 11;
            final int expected = 4;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeTopDown(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {1, 2, 3};
            final int total = 7;
            final int expected = 3;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeTopDown(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {3, 5};
            final int total = 7;
            final int expected = -1;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeTopDown(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
    }

    @Test
    public void coinChangeRecursive() {
        {
            final int[] denominations = {1, 2, 3};
            final int total = 5;
            final int expected = 2;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeRecursive(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {1, 2, 3};
            final int total = 11;
            final int expected = 4;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeRecursive(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {1, 2, 3};
            final int total = 7;
            final int expected = 3;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeRecursive(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
        {
            final int[] denominations = {3, 5};
            final int total = 7;
            final int expected = -1;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChangeRecursive(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
        }
    }
}