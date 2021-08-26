package com.avi.practice.leetcode.monthly.august2021;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by navinash on 26/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumOfSquareNumbersTest  {


    @Test
    public void judgeSquareSum_LinearSearch1() {
        final SumOfSquareNumbers solver = new SumOfSquareNumbers();
        final int c = 8;
        final boolean expected = true;
        final boolean actual = solver.judgeSquareSum_LinearSearch(c);
        Assert.assertEquals(String.valueOf(c), expected, actual);
    }

    @Test
    public void judgeSquareSum_UsingMap1() {
        final SumOfSquareNumbers solver = new SumOfSquareNumbers();
        final int c = 8;
        final boolean expected = true;
        final boolean actual = solver.judgeSquareSum_UsingMap(c);
        Assert.assertEquals(String.valueOf(c), expected, actual);
    }

    @Test
    public void judgeSquareSum_BinarySearch1() {
        final SumOfSquareNumbers solver = new SumOfSquareNumbers();
        final int c = 8;
        final boolean expected = true;
        final boolean actual = solver.judgeSquareSum_BinarySearch(c);
        Assert.assertEquals(String.valueOf(c), expected, actual);
    }
}