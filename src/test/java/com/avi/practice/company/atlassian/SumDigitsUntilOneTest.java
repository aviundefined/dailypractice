package com.avi.practice.company.atlassian;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumDigitsUntilOneTest {

    private final SumDigitsUntilOne solver = new SumDigitsUntilOne();

    @Test
    public void sum1() {
        final int n = 49;
        final int expected = 4;
        final int actual = solver.solve(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }

    @Test
    public void sum2() {
        final int n = 123456789;
        final int expected = 9;
        final int actual = solver.solve(n);
        Assert.assertEquals(String.valueOf(n), expected, actual);
    }
}