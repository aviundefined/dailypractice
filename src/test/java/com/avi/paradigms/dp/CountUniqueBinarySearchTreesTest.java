package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 05/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountUniqueBinarySearchTreesTest {

    @Test
    public void count() {
        final CountUniqueBinarySearchTrees solver = new CountUniqueBinarySearchTrees();
        {
            final int n = 0;
            final int expected = 1;
            final int actual = solver.count(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 1;
            final int expected = 1;
            final int actual = solver.count(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 2;
            final int expected = 2;
            final int actual = solver.count(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 3;
            final int expected = 5;
            final int actual = solver.count(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
        {
            final int n = 4;
            final int expected = 14;
            final int actual = solver.count(n);
            Assert.assertEquals(String.valueOf(n), expected, actual);
        }
    }
}
