package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FindSumPairsTest {

    @Test
    public void case1() {
        final int[] nums1 = {1, 1, 2, 2, 2, 3};
        final int[] nums2 = {1, 4, 5, 2, 5, 4};
        final FindSumPairs solver = new FindSumPairs(nums1, nums2);
        {
            final int tot = 7;
            final int expected = 8;
            final int count = solver.count(tot);
            Assert.assertEquals(expected, count);
        }
        solver.add(3, 2);
        {
            final int tot = 8;
            final int expected = 2;
            final int count = solver.count(tot);
            Assert.assertEquals(expected, count);
        }
        {
            final int tot = 4;
            final int expected = 1;
            final int count = solver.count(tot);
            Assert.assertEquals(expected, count);
        }
        solver.add(0 , 1);
        solver.add(1, 1);
        {
            final int tot = 7;
            final int expected = 11;
            final int count = solver.count(tot);
            Assert.assertEquals(expected, count);
        }
    }
}