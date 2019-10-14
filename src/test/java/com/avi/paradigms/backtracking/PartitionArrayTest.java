package com.avi.paradigms.backtracking;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 15/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionArrayTest {

    @Test
    public void canPartition() {
        final int[] a = {1, 4, 5, 2, 3};
        CommonUtils.printArr(a);
        final PartitionArray solver = new PartitionArray(a);
        {
            final int k = 1;
            final boolean expected = true;
            final boolean actual = solver.canPartition(k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 2;
            final boolean expected = false;
            final boolean actual = solver.canPartition(k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 3;
            final boolean expected = true;
            final boolean actual = solver.canPartition(k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 4;
            final boolean expected = false;
            final boolean actual = solver.canPartition(k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
        {
            final int k = 5;
            final boolean expected = false;
            final boolean actual = solver.canPartition(k);
            Assert.assertEquals(String.valueOf(k), expected, actual);
        }
    }
}
