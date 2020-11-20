package com.avi.practice.leetcode.biweekly;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumDeletionsToMakeStringBalancedTest {

    private static final MinimumDeletionsToMakeStringBalanced solver = new MinimumDeletionsToMakeStringBalanced();

    @Test
    public void minimumDeletions() {
        {
            final String s = "aababbab";
            final int expected = 2;
            final int actual = solver.minimumDeletions(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "bbaaaaabb";
            final int expected = 2;
            final int actual = solver.minimumDeletions(s);
            Assert.assertEquals(s, expected, actual);
        }
    }
}