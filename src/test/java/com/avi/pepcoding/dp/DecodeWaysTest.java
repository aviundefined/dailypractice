package com.avi.pepcoding.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DecodeWaysTest {

    private static final DecodeWays solver = new DecodeWays();
    @Test
    public void decodeWays1() {

        final String s = "21123";
        final int expected = 8;
        final int actual = solver.decodeWays(s);
        Assert.assertEquals(s, expected, actual);
    }
}