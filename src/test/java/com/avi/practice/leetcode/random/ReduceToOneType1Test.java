package com.avi.practice.leetcode.random;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 15/04/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ReduceToOneType1Test {

    @Test
    public void minSteps() {
        final ReduceToOneType1 solver = new ReduceToOneType1();
        final int n = 11;
        final int expected = 4;
        final int actual = solver.minSteps(n);
        Assert.assertEquals(n +"", expected, actual);
    }
}