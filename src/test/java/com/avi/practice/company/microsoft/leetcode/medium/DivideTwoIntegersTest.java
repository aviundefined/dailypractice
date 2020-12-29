package com.avi.practice.company.microsoft.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DivideTwoIntegersTest {

    private static final DivideTwoIntegers solver = new DivideTwoIntegers();

    @Test
    public void divide1() {
        final int dividend = -2147483648;
        final int divisor = -1;
        final int expected = 2147483647;
        final int actual = solver.divide(dividend, divisor);
        Assert.assertEquals(String.format("%s/%s", dividend, divisor), expected, actual);
    }

    @Test
    public void divide2() {
        final int dividend = -2147483648;
        final int divisor = 1;
        final int expected =  -2147483648;
        final int actual = solver.divide(dividend, divisor);
        Assert.assertEquals(String.format("%s/%s", dividend, divisor), expected, actual);
    }

    @Test
    public void divide3() {
        final int dividend = -2147483648;
        final int divisor = 2;
        final int expected =  -1073741824;
        final int actual = solver.divide(dividend, divisor);
        Assert.assertEquals(String.format("%s/%s", dividend, divisor), expected, actual);
    }

    @Test
    public void divide4() {
        final int dividend = 10;
        final int divisor = 3;
        final int expected =  3;
        final int actual = solver.divide(dividend, divisor);
        Assert.assertEquals(String.format("%s/%s", dividend, divisor), expected, actual);
    }

    @Test
    public void divide5() {
       final String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        final String[] strs = ip.split(":");
        System.out.println(strs.length);
        System.out.println(Arrays.toString(strs));
    }
}