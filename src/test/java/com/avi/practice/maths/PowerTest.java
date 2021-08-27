package com.avi.practice.maths;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 27/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PowerTest  {

    @Test
    public void testMyPow1() {
        final Power solver  = new Power();
        final double x = 2;
        final double n = 10;
        final double expected = 1024.00D;
        final double actual = solver.myPow(x, n);
        Assert.assertEquals(String.format("(%s)^%s", x, n), expected, actual, 2);
    }

    @Test
    public void testMyPow2() {
        final Power solver  = new Power();
        final double x = 2.1;
        final double n = 3;
        final double expected = 9.26100D;
        final double actual = solver.myPow(x, n);
        Assert.assertEquals(String.format("(%s)^%s", x, n), expected, actual, 2);
    }

    @Test
    public void testMyPow3() {
        final Power solver  = new Power();
        final double x = 2;
        final double n = -2;
        final double expected = .25000D;
        final double actual = solver.myPow(x, n);
        Assert.assertEquals(String.format("(%s)^%s", x, n), expected, actual, 2);
    }

    @Test
    public void testMyPow4() {
        final Power solver  = new Power();
        final double x = 2;
        final double n = -3;
        final double expected = (1D/8D);
        final double actual = solver.myPow(x, n);
        Assert.assertEquals(String.format("(%s)^%s", x, n), expected, actual, 2);
    }

    @Test
    public void testMyPow5() {
        final Power solver  = new Power();
        final double x = -2;
        final double n = -3;
        final double expected = -(1D/8D);
        final double actual = solver.myPow(x, n);
        Assert.assertEquals(String.format("(%s)^%s", x, n), expected, actual, 2);
    }
}