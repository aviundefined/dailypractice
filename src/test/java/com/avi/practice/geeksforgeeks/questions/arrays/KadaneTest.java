package com.avi.practice.geeksforgeeks.questions.arrays;

import com.avi.practice.geeksforgeeks.questions.arrays.Kadane.Result;
import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 24/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class KadaneTest {

    private final Kadane kadane = new Kadane();

    @Test
    public void solve() {
        {
            final int[] a = {-1, -2, -3, -4};
            CommonUtils.printArr(a);
            final Result expected = new Result(-1, 0, 0);
            final Result actual = kadane.solve(a);
            Assert.assertNotNull(actual);
            System.out.println(actual);
            for (int i = actual.start; i <= actual.end; i++) {
                System.out.print(a[i] + ",");
            }
            Assert.assertEquals(expected, actual);
            System.out.println("\n------------------------------");
        }
        {
            final int[] a = {1, 2, 3, -2, 5};
            CommonUtils.printArr(a);
            final Result expected = new Result(9, 0, 4);
            final Result actual = kadane.solve(a);
            Assert.assertNotNull(actual);
            System.out.println(actual);
            for (int i = actual.start; i <= actual.end; i++) {
                System.out.print(a[i] + ",");
            }
            Assert.assertEquals(expected, actual);
            System.out.println("\n------------------------------");
        }

        {
            final int[] a = {-1, 2, 3, -2, 5};
            CommonUtils.printArr(a);
            final Result expected = new Result(8, 1, 4);
            final Result actual = kadane.solve(a);
            Assert.assertNotNull(actual);
            System.out.println(actual);
            for (int i = actual.start; i <= actual.end; i++) {
                System.out.print(a[i] + ",");
            }
            Assert.assertEquals(expected, actual);
            System.out.println("\n------------------------------");
        }
        {
            final int[] a = {-4, -2, -1, -3};
            CommonUtils.printArr(a);
            final Result expected = new Result(-1, 2, 2);
            final Result actual = kadane.solve(a);
            Assert.assertNotNull(actual);
            System.out.println(actual);
            for (int i = actual.start; i <= actual.end; i++) {
                System.out.print(a[i] + ",");
            }
            Assert.assertEquals(expected, actual);
            System.out.println("\n------------------------------");
        }
    }
}