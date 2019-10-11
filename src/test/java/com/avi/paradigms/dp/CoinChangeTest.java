package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 24/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CoinChangeTest {

    @Test
    public void change() {
        {
            final int[] coins = {1, 2, 3};
            CommonUtils.printArr(coins);
            final CoinChange solver = new CoinChange(coins);
            {
                final int sum = 0;
                final int expected = 1;
                final int actual = solver.change(sum);
                Assert.assertEquals(String.valueOf(sum), expected, actual);
            }
            {
                final int sum = 1;
                final int expected = 1;
                final int actual = solver.change(sum);
                Assert.assertEquals(String.valueOf(sum), expected, actual);
            }
            {
                final int sum = 2;
                final int expected = 2;
                final int actual = solver.change(sum);
                Assert.assertEquals(String.valueOf(sum), expected, actual);
            }
            {
                final int sum = 3;
                final int expected = 3;
                final int actual = solver.change(sum);
                Assert.assertEquals(String.valueOf(sum), expected, actual);
            }
            {
                final int sum = 4;
                final int expected = 4;
                final int actual = solver.change(sum);
                Assert.assertEquals(String.valueOf(sum), expected, actual);
            }
            {
                final int sum = 5;
                final int expected = 5;
                final int actual = solver.change(sum);
                Assert.assertEquals(String.valueOf(sum), expected, actual);
            }
            {
                final int sum = 6;
                final int expected = 7;
                final int actual = solver.change(sum);
                Assert.assertEquals(String.valueOf(sum), expected, actual);
            }
        }
    }

    @Test
    public void minNumberOfCoinsForChange() {
        final int[] coins = {1, 2, 5};
        CommonUtils.printArr(coins);
        final CoinChange solver = new CoinChange(coins);
        {
            final int sum = 0;
            final int expected = 0;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 1;
            final int expected = 1;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 2;
            final int expected = 1;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 3;
            final int expected = 2;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 4;
            final int expected = 2;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 5;
            final int expected = 1;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 6;
            final int expected = 2;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 7;
            final int expected = 2;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 8;
            final int expected = 3;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 9;
            final int expected = 3;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 10;
            final int expected = 2;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
        {
            final int sum = 11;
            final int expected = 3;
            final int actual = solver.minNumberOfCoinsForChange(sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
        }
    }
}
