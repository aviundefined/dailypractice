package com.avi.practice.leetcode.weeklycontest.num157;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 23/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestArithmeticSubsequenceGivenDifferenceTest {

    @Test
    public void longestSubsequence() {
        final LongestArithmeticSubsequenceGivenDifference solver = new LongestArithmeticSubsequenceGivenDifference();
        {
            final int[] arr = {1, 2, 3, 4};
            final int difference = 1;
            CommonUtils.printArr(arr);
            System.out.println("Difference: " + difference);
            final int expected = 4;
            final int actual = solver.longestSubsequence(arr, difference);
            Assert.assertEquals(expected, actual);
        }
        {
            final int[] arr = {1, 3, 5, 7};
            final int difference = 1;
            CommonUtils.printArr(arr);
            System.out.println("Difference: " + difference);
            final int expected = 1;
            final int actual = solver.longestSubsequence(arr, difference);
            Assert.assertEquals(expected, actual);
        }
        {
            final int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
            final int difference = -2;
            CommonUtils.printArr(arr);
            System.out.println("Difference: " + difference);
            final int expected = 4;
            final int actual = solver.longestSubsequence(arr, difference);
            Assert.assertEquals(expected, actual);
        }
        {
            final int[] arr = {3, 0, -3, 4, -4, 7, 6};
            final int difference = 3;
            CommonUtils.printArr(arr);
            System.out.println("Difference: " + difference);
            final int expected = 2;
            final int actual = solver.longestSubsequence(arr, difference);
            Assert.assertEquals(expected, actual);
        }
    }
}