package com.avi.practice.company.microsoft.interviewbit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TrailingZerosInFactorialTest {

    private static final TrailingZerosInFactorial solver  = new TrailingZerosInFactorial();
    @Test
    public void count50() {
        final int n  = 50;
        final int expected = 12;
        final int actual = solver.count(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }
}