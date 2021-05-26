package com.avi.pepcoding.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumSumSubsequenceNonConsecutiveNumbersTest {

    private static final MaximumSumSubsequenceNonConsecutiveNumbers solver = new MaximumSumSubsequenceNonConsecutiveNumbers();

    @Test
    public void maxSum() {
        final int[] nums = {5, 10, 10, 100, 5, 6};
        final int expected = 116;
        final int actual = solver.maxSum(nums);
        Assert.assertEquals(Arrays.toString(nums), expected, actual);
    }
}