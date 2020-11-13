package com.avi.educative.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 13/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PartitionSubsetTest {
    private static final PartitionSubset ps = new PartitionSubset();

    @Test
    public void canPartitionDPMemoization() {
        {
            int[] num = {1, 2, 3, 4};
            final boolean expected = true;
            CommonUtils.printArr(num);
            final boolean actual = ps.canPartitionDPMemoization(num);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }
        {
            int[] num = {1, 1, 3, 4, 7};
            final boolean expected = true;
            CommonUtils.printArr(num);
            final boolean actual = ps.canPartitionDPMemoization(num);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }
        {
            int[] num = {2, 3, 4, 6};
            final boolean expected = false;
            CommonUtils.printArr(num);
            final boolean actual = ps.canPartitionDPMemoization(num);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }
    }

    @Test
    public void canPartitionDPBottomUp() {
        {
            int[] num = {1, 2, 3, 4};
            final boolean expected = true;
            CommonUtils.printArr(num);
            final boolean actual = ps.canPartitionDPBottomUp(num);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }
        {
            int[] num = {1, 1, 3, 4, 7};
            final boolean expected = true;
            CommonUtils.printArr(num);
            final boolean actual = ps.canPartitionDPBottomUp(num);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }
        {
            int[] num = {2, 3, 4, 6};
            final boolean expected = false;
            CommonUtils.printArr(num);
            final boolean actual = ps.canPartitionDPMemoization(num);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }
    }
}