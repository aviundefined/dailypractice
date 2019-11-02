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
    public void singleNumber() {
        {
            final int[] nums = {2, 2, 2, 3};
            final int expected = 3;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {0, 1, 0, 1, 0, 1, 99};
            final int expected = 99;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {0, 1, 99, 1, 99, 1, 99};
            final int expected = 0;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {2, 99, 99, 2, -3, 99, 2};
            final int expected = -3;
            CommonUtils.printArr(nums);
            final int singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
    }
}