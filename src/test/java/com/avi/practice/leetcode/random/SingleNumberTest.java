package com.avi.practice.leetcode.random;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 02/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SingleNumberTest {

    @Test
    public void missingNumber() {
        {
            final int[] nums = {3,0,1};
            final int expected = 2;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.missingNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {9,6,4,2,3,5,7,0,1};
            final int expected = 8;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.missingNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
    }

    @Test
    public void findTheDifference() {
        {
            final String s = "abcd";
            final String t = "abcde";
            final char expected = 'e';
            final char actual = SingleNumber.findTheDifference(s, t);
            Assert.assertEquals(String.format("Difference in %s & %s", s, t), expected, actual);
        }
    }


    @Test
    public void findDuplicate() {
        {
            final int[] nums = {1,3,4,2,2};
            final int expected = 2;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.findDuplicate(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {3,1,3,4,2};
            final int expected = 3;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.findDuplicate(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {2,2,2,2,2};
            final int expected = 2;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.findDuplicate(nums);
            Assert.assertEquals(expected, singleNumber);
        }
    }

    @Test
    public void singleNumber1() {
        {
            final int[] nums = {2,2,1};
            final int expected = 1;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber1(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {4,1,2,1,2};
            final int expected = 4;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber1(nums);
            Assert.assertEquals(expected, singleNumber);
        }
    }

    @Test
    public void singleNumber2() {
        {
            final int[] nums = {2, 2, 2, 3};
            final int expected = 3;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber2(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {0, 1, 0, 1, 0, 1, 99};
            final int expected = 99;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber2(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {0, 1, 99, 1, 99, 1, 99};
            final int expected = 0;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber2(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {2, 99, 99, 2, -3, 99, 2};
            final int expected = -3;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber2(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {-1,-1,-1,-2147483648};
            final int expected = -2147483648;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber2(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555};
            final int expected = -2147483648;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber2(nums);
            Assert.assertEquals(expected, singleNumber);
        }
    }
}