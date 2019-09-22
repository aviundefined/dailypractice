package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 22/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UglyNumberTest {

    @Test
    public void uglyNumber() {
        final UglyNumber solver = new UglyNumber();
        {
            final int n = 2;
            final int expected = 2;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 3;
            final int expected = 3;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 4;
            final int expected = 4;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 5;
            final int expected = 5;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 6;
            final int expected = 6;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 7;
            final int expected = 8;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 8;
            final int expected = 9;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 9;
            final int expected = 10;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 10;
            final int expected = 12;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 11;
            final int expected = 15;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 15;
            final int expected = 24;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 150;
            final int expected = 5832;
            final int actual = solver.uglyNumber(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
    }
}
