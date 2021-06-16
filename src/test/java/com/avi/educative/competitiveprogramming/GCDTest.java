package com.avi.educative.competitiveprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 16/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GCDTest {

    private static final GCD solver = new GCD();
    @Test
    public void gcd1() {
        final int a = 100;
        final int b = 20;
        final int expected = 20;
        final int actual = solver.gcd(a, b);
        Assert.assertEquals(String.format("%s, %s", a, b), expected, actual);
    }

    @Test
    public void gcd2() {
        final int a = 24;
        final int b = 15;
        final int expected = 3;
        final int actual = solver.gcd(a, b);
        Assert.assertEquals(String.format("%s, %s", a, b), expected, actual);
    }


    @Test
    public void gcd3() {
        final int a = 15;
        final int b = 24;
        final int expected = 3;
        final int actual = solver.gcd(a, b);
        Assert.assertEquals(String.format("%s, %s", a, b), expected, actual);
    }


}