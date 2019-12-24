package com.avi.practice.geeksforgeeks.questions.arrays;

import com.avi.practice.geeksforgeeks.questions.arrays.SubArrayWithGivenSum;
import com.avi.practice.geeksforgeeks.questions.arrays.SubArrayWithGivenSum.StartEnd;
import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 22/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SubArrayWithGivenSumTest {

    private final SubArrayWithGivenSum solver = new SubArrayWithGivenSum();

    @Test
    public void solve() {
        {
            final int[] arr = {1, 2, 3, 7, 5};
            final int sum = 12;
            CommonUtils.printArr(arr);
            System.out.println("Sum: " + sum);
            final StartEnd expected = new StartEnd(1, 3);
            final StartEnd actual = solver.solve(arr, sum);
            Assert.assertNotNull(actual);
            Assert.assertEquals(expected, actual);
            CommonUtils.printArr(arr, expected.getStart(), expected.getEnd());
            System.out.println("-------------------------------------");
        }
        {
            final int[] arr = {1, 5, 8, 2, 6, 7};
            final int sum = 16;
            CommonUtils.printArr(arr);
            System.out.println("Sum: " + sum);
            final StartEnd expected = new StartEnd(0, 3);
            final StartEnd actual = solver.solve(arr, sum);
            Assert.assertNotNull(actual);
            Assert.assertEquals(actual.toString(), expected, actual);
            CommonUtils.printArr(arr, expected.getStart(), expected.getEnd());
            System.out.println("-------------------------------------");
        }
        {
            final int[] arr = {13, 5, 8, 2, 6, 7};
            final int sum = 16;
            CommonUtils.printArr(arr);
            System.out.println("Sum: " + sum);
            final StartEnd expected = new StartEnd(2, 4);
            final StartEnd actual = solver.solve(arr, sum);
            Assert.assertNotNull(actual);
            Assert.assertEquals(actual.toString(), expected, actual);
            CommonUtils.printArr(arr, expected.getStart(), expected.getEnd());
            System.out.println("-------------------------------------");
        }

        {
            final int[] arr = {13, 5, 0, 0, 8, 2, 6, 7};
            final int sum = 16;
            CommonUtils.printArr(arr);
            System.out.println("Sum: " + sum);
            final StartEnd expected = new StartEnd(2, 6);
            final StartEnd actual = solver.solve(arr, sum);
            Assert.assertNotNull(actual);
            Assert.assertEquals(actual.toString(), expected, actual);
            CommonUtils.printArr(arr, expected.getStart(), expected.getEnd());
            System.out.println("-------------------------------------");
        }
    }
}