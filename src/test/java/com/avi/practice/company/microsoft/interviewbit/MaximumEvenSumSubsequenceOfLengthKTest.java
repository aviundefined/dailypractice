package com.avi.practice.company.microsoft.interviewbit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumEvenSumSubsequenceOfLengthKTest {

    private static final MaximumEvenSumSubsequenceOfLengthK solver = new MaximumEvenSumSubsequenceOfLengthK();

    @Test
    public void maxEvenSum1() {
        final int[] arr = {4, 2, 6, 7, 8};
        final int k = 3;
        final int expected = 18;
        final int actual = solver.maxEvenSum(arr, k);
        Assert.assertEquals(String.format("arr: %s, length: %s", Arrays.toString(arr), k), expected, actual);
    }

    @Test
    public void maxEvenSum2() {
        final int[] arr = {5, 5, 1, 1, 3};
        final int k = 3;
        final int expected = -1;
        final int actual = solver.maxEvenSum(arr, k);
        Assert.assertEquals(String.format("arr: %s, length: %s", Arrays.toString(arr), k), expected, actual);
    }
}