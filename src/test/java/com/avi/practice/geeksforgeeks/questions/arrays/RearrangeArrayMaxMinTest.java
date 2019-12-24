package com.avi.practice.geeksforgeeks.questions.arrays;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 24/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RearrangeArrayMaxMinTest {

    private RearrangeArrayMaxMin solver = new RearrangeArrayMaxMin();

    @Test
    public void arrangeInPlace() {
        {
            final int[] a = {1, 2, 3, 4, 5, 6};
            CommonUtils.printArr(a);
            final int[] expected = {6, 1, 5, 2, 4, 3};
            solver.arrangeInPlace(a);
            CommonUtils.printArr(expected);
            CommonUtils.printArr(a);
            Assert.assertArrayEquals(expected, a);
            System.out.println("------------------------------");
        }
        {
            final int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
            CommonUtils.printArr(a);
            final int[] expected = {110, 10, 100, 20, 90, 30, 80, 40, 70, 50, 60};
            solver.arrangeInPlace(a);
            CommonUtils.printArr(expected);
            CommonUtils.printArr(a);
            Assert.assertArrayEquals(expected, a);
            System.out.println("------------------------------");
        }
    }
}