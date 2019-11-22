package com.avi.practice.leetcode.weeklycontest.num161;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 03/11/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberOfNiceSubarraysTest {

    @Test
    public void numberOfSubarrays() {
        final NumberofNiceSubarrays solver =new NumberofNiceSubarrays();
        {
            final int[] nums = {1,1,2,1,1};
            final int k = 3;
            final int expected = 2;
            CommonUtils.printArr(nums);
            System.out.println("k: "+ k);
            final int actual = solver.numberOfSubarrays(nums, k);
            Assert.assertEquals(expected, actual);

        }
        {
            final int[] nums = {2,4,6};
            final int k = 1;
            final int expected = 0;
            CommonUtils.printArr(nums);
            System.out.println("k: "+ k);
            final int actual = solver.numberOfSubarrays(nums, k);
            Assert.assertEquals(expected, actual);

        }
        {
            // 1, 1
            // 1, 1, 2
            // 1, 2, 1
            // 2, 1, 1
            // 1, 1
            final int[] nums = {1,1,2,1,1};
            final int k = 2;
            final int expected = 5;
            CommonUtils.printArr(nums);
            System.out.println("k: "+ k);
            final int actual = solver.numberOfSubarrays(nums, k);
            Assert.assertEquals(expected, actual);

        }
        {
            final int[] nums = {2,2,2,1,2,2,1,2,2,2};
            final int k = 2;
            final int expected = 16;
            CommonUtils.printArr(nums);
            System.out.println("k: "+ k);
            final int actual = solver.numberOfSubarrays(nums, k);
            Assert.assertEquals(expected, actual);

        }
    }
}