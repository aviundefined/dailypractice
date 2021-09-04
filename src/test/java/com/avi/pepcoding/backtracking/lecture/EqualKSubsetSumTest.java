package com.avi.pepcoding.backtracking.lecture;

import junit.framework.TestCase;

/**
 * Created by navinash on 04/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class EqualKSubsetSumTest extends TestCase {

    public void testNumEqualKSubsetSum1() {
        final EqualKSubsetSum solver = new EqualKSubsetSum();
        final int[] nums = {9, 4, 5, 9};
        final int k = 3;
        final int count = solver.numEqualKSubsetSum(nums, k);
        System.out.println(count);
    }
}