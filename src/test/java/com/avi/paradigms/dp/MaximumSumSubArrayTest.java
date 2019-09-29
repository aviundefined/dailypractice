package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 28/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumSumSubArrayTest {

    @Test
    public void maxSumSubArray() {
        {
            final int[] a = null;
            final MaximumSumSubArray solver = new MaximumSumSubArray(a);
            final MaximumSumSubArray.Result result = solver.maxSumSubArray();
            Assert.assertNull(result);
        }
        {
            final int[] a = {-2};
            CommonUtils.printArr(a);
            final MaximumSumSubArray solver = new MaximumSumSubArray(a);
            final int sum = -2;
            final int start = 0;
            final int end = 0;
            final MaximumSumSubArray.Result result = solver.maxSumSubArray();
            System.out.println(result);
            Assert.assertNotNull(result);
            Assert.assertEquals(result.toString(), sum, result.sum);
            Assert.assertEquals(result.toString(), start, result.start);
            Assert.assertEquals(result.toString(), end, result.end);
        }
        {
            final int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
            CommonUtils.printArr(a);
            final MaximumSumSubArray solver = new MaximumSumSubArray(a);
            final int sum = 7;
            final int start = 2;
            final int end = 6;
            final MaximumSumSubArray.Result result = solver.maxSumSubArray();
            System.out.println(result);
            Assert.assertNotNull(result);
            Assert.assertEquals(result.toString(), sum, result.sum);
            Assert.assertEquals(result.toString(), start, result.start);
            Assert.assertEquals(result.toString(), end, result.end);
        }
    }


    @Test
    public void compare() {
        {
            final int[] a = null;
            final MaximumSumSubArray solver = new MaximumSumSubArray(a);
            final MaximumSumSubArray.Result result = solver.maxSumSubArray();
            final MaximumSumSubArray.Result kadane = solver.kadane();
            Assert.assertNull(result);
            Assert.assertNull(kadane);
        }
        {
            final int[] a = {-2};
            CommonUtils.printArr(a);
            final MaximumSumSubArray solver = new MaximumSumSubArray(a);
            final int sum = -2;
            final int start = 0;
            final int end = 0;
            final MaximumSumSubArray.Result result = solver.maxSumSubArray();
            System.out.println(result);
            Assert.assertNotNull(result);
            Assert.assertEquals(result.toString(), sum, result.sum);
            Assert.assertEquals(result.toString(), start, result.start);
            Assert.assertEquals(result.toString(), end, result.end);
            final MaximumSumSubArray.Result kadane = solver.kadane();
            System.out.println(kadane);
            Assert.assertNotNull(kadane);
            Assert.assertEquals(kadane.toString(), sum, kadane.sum);
            Assert.assertEquals(kadane.toString(), start, kadane.start);
            Assert.assertEquals(kadane.toString(), end, kadane.end);

        }
        {
            final int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
            CommonUtils.printArr(a);
            final MaximumSumSubArray solver = new MaximumSumSubArray(a);
            final int sum = 7;
            final int start = 2;
            final int end = 6;
            final MaximumSumSubArray.Result result = solver.maxSumSubArray();
            System.out.println(result);
            Assert.assertNotNull(result);
            Assert.assertEquals(result.toString(), sum, result.sum);
            Assert.assertEquals(result.toString(), start, result.start);
            Assert.assertEquals(result.toString(), end, result.end);
            final MaximumSumSubArray.Result kadane = solver.kadane();
            System.out.println(kadane);
            Assert.assertNotNull(kadane);
            Assert.assertEquals(kadane.toString(), sum, kadane.sum);
            Assert.assertEquals(kadane.toString(), start, kadane.start);
            Assert.assertEquals(kadane.toString(), end, kadane.end);
        }
    }
}
