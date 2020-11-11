package com.avi.practice.arrays;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 11/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class InversionCountTest {

    @Test
    public void inversionCount() {
        {
            final int[] arr = {8, 4, 9, 2};
            final int expected = 4;
            CommonUtils.printArr(arr);
            final int actual = InversionCount.inversionCount(arr);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }

        {
            final int[] arr = {8, 4, 9, 2, 8};
            final int expected = 5;
            CommonUtils.printArr(arr);
            final int actual = InversionCount.inversionCount(arr);
            Assert.assertEquals(expected, actual);
            System.out.println("---------------------");
        }
    }
}