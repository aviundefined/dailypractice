package com.avi.pepcoding.backtracking;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JosephusTest {

    private static final Josephus solver = new Josephus();

    @Test
    public void survive1() {
        final int n = 5;
        final int k = 3;
        final int expected = 3;
        final int actual = solver.survive(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }

    @Test
    public void survive2() {
        final int n = 5;
        final int k = 1;
        final int expected = 5;
        final int actual = solver.survive(n, k);
        Assert.assertEquals(String.format("(%s, %s)", n, k), expected, actual);
    }
}