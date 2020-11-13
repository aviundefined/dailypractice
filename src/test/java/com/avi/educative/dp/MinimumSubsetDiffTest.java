package com.avi.educative.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumSubsetDiffTest {

    private static final MinimumSubsetDiff ps = new MinimumSubsetDiff();

    @Test
    public void minSubsetDiffBottomUp() {
        {
            int[] num = {1, 2, 3, 9};
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffBottomUp(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");
        }
        {
            int[] num = new int[]{1, 2, 7, 1, 5};
            final int expected = 0;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffBottomUp(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");

        }
        {
            int[] num = new int[]{1, 3, 100, 4};
            final int expected = 92;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffBottomUp(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");
        }
    }

    @Test
    public void minSubsetDiffTopDown() {
        {
            int[] num = {1, 2, 3, 9};
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffTopDown(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");
        }
        {
            int[] num = new int[]{1, 2, 7, 1, 5};
            final int expected = 0;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffTopDown(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");

        }
        {
            int[] num = new int[]{1, 3, 100, 4};
            final int expected = 92;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffTopDown(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");
        }
    }

    @Test
    public void minSubsetDiffRecursive() {
        {
            int[] num = {1, 2, 3, 9};
            final int expected = 3;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffRecursive(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");
        }
        {
            int[] num = new int[]{1, 2, 7, 1, 5};
            final int expected = 0;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffRecursive(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");

        }
        {
            int[] num = new int[]{1, 3, 100, 4};
            final int expected = 92;
            CommonUtils.printArr(num);
            final int actual = ps.minSubsetDiffRecursive(num);
            Assert.assertEquals(expected, actual);
            System.out.println("----------------------");
        }
    }
}