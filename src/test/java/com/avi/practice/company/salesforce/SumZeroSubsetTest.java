package com.avi.practice.company.salesforce;

import com.avi.practice.company.salesforce.SumZeroSubset.SubArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumZeroSubsetTest {

    private static final SumZeroSubset solver = new SumZeroSubset();

    @Test
    public void zeroSumSubArray() {
        {
            final int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
            final Set<SubArray> expected = new HashSet<>();
            expected.add(new SubArray(2, 4));
            expected.add(new SubArray(2, 6));
            expected.add(new SubArray(5, 6));
            expected.add(new SubArray(6, 9));
            expected.add(new SubArray(0, 10));
            final Set<SubArray> actual = solver.zeroSumSubArray(arr);
            Assert.assertEquals(Arrays.toString(arr), expected, actual);
        }
    }
}