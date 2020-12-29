package com.avi.paradigms.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 29/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxAndInArrayTest {

    private static final MaxAnd solver = new MaxAnd();
    @Test
    public void maxAnd() {
        final int []arr = {4, 8, 6, 2};
        final int expected = 4;
        final int actual = solver.maxAnd(arr);
        Assert.assertEquals(Arrays.toString(arr), expected, actual);
    }
}