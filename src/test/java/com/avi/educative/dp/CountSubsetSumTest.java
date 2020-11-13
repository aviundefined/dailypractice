package com.avi.educative.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountSubsetSumTest {
    private static final CountSubsetSum ss = new CountSubsetSum();

    @Test
    public void countSubsetsRecursive() {
        {
            int[] num = {1, 1, 2, 3};
            final int sum = 4;
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ss.countSubsetsRecursive(num, sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
            System.out.println("----------------------");
        }
        {
            int[] num = {1, 2, 7, 1, 5};
            final int sum = 9;
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ss.countSubsetsRecursive(num, sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
            System.out.println("----------------------");
        }
    }

    @Test
    public void countSubsetsTopDown() {
        {
            int[] num = {1, 1, 2, 3};
            final int sum = 4;
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ss.countSubsetsTopDown(num, sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
            System.out.println("----------------------");
        }
        {
            int[] num = {1, 2, 7, 1, 5};
            final int sum = 9;
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ss.countSubsetsTopDown(num, sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
            System.out.println("----------------------");
        }
    }

    @Test
    public void countSubsetsBottomUp() {
        {
            int[] num = {1, 1, 2, 3};
            final int sum = 4;
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ss.countSubsetsBottomUp(num, sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
            System.out.println("----------------------");
        }
        {
            int[] num = {1, 2, 7, 1, 5};
            final int sum = 9;
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ss.countSubsetsBottomUp(num, sum);
            Assert.assertEquals(String.valueOf(sum), expected, actual);
            System.out.println("----------------------");
        }
    }
}