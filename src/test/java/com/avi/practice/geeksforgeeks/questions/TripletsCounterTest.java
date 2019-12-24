package com.avi.practice.geeksforgeeks.questions;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TripletsCounterTest {

    private final TripletsCounter solver = new TripletsCounter();
    @Test
    public void count() {
        {
            final int[] a = {1, 5, 3, 2};
            // 1, 2, 3, 5
            final int expected = 2;
            CommonUtils.printArr(a);
            final int actual = solver.count(a);
            Assert.assertEquals(expected, actual);
            System.out.println("------------------------------");
        }
        {
            final int[] a = {3, 2, 7 };
            final int expected = -1;
            CommonUtils.printArr(a);
            final int actual = solver.count(a);
            Assert.assertEquals(expected, actual);
            System.out.println("------------------------------");
        }
    }

    @Test
    public void countOptimized() {
        {
            final int[] a = {1, 5, 3, 2};
            // 1, 2, 3, 5
            final int expected = 2;
            CommonUtils.printArr(a);
            final int actual = solver.countOptimized(a);
            Assert.assertEquals(expected, actual);
            System.out.println("------------------------------");
        }
        {
            final int[] a = {3, 2, 7 };
            final int expected = -1;
            CommonUtils.printArr(a);
            final int actual = solver.countOptimized(a);
            Assert.assertEquals(expected, actual);
            System.out.println("------------------------------");
        }
    }
}