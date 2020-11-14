package com.avi.educative.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CoinChangeTest {

    private static final CoinChange cc = new CoinChange();

    @Test
    public void coinChange() {

        {
            final int[] denominations = {1, 2, 3};
            final int total = 5;
            final int expected = 5;
            CommonUtils.printArr(denominations);
            final int actual = cc.coinChange(denominations, total);
            Assert.assertEquals(String.valueOf(total), expected, actual);
            System.out.println("------------------------");
        }

    }
}