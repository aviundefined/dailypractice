package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 29/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumSumRectangleTest {

    @Test
    public void maxSum() {
        {
            final int[][] mat =
                    {
                            {1, 2, -1, -4, -20},
                            {-8, -3, 4, 2, 1},
                            {3, 8, 10, 1, 3},
                            {-4, -1, 1, 7, -6}
                    };
            CommonUtils.printMatrix(mat);
            final MaximumSumRectangle solver = new MaximumSumRectangle(mat);
            final int sum = 29;
            final int left = 1;
            final int top = 1;
            final int right = 3;
            final int bottom = 3;
            final MaximumSumRectangle.Result result = solver.maxSum();
            Assert.assertNotNull(result);
            System.out.println(result);
            Assert.assertEquals(result.toString(), sum, result.sum);
            Assert.assertEquals(result.toString(), left, result.left);
            Assert.assertEquals(result.toString(), right, result.right);
            Assert.assertEquals(result.toString(), top, result.top);
            Assert.assertEquals(result.toString(), bottom, result.bottom);
        }
    }
}
