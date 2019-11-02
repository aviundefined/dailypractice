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
            final long expected = 3L;
            CommonUtils.printArr(nums);
            final long singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {0, 1, 0, 1, 0, 1, 99};
            final long expected = 99L;
            CommonUtils.printArr(nums);
            final long singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {0, 1, 99, 1, 99, 1, 99};
            final long expected = 0L;
            CommonUtils.printArr(nums);
            final long singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {2, 99, 99, 2, -3, 99, 2};
            final long expected = -3L;
            CommonUtils.printArr(nums);
            final long singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {-1,-1,-1,-2147483648};
            final long expected = -2147483648L;
            CommonUtils.printArr(nums);
            final long singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
        {
            final int[] nums = {-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555};
            final long expected = -2147483648L;
            CommonUtils.printArr(nums);
            final long singleNumber = SingleNumber.singleNumber(nums);
            Assert.assertEquals(expected, singleNumber);
        }
    }
}