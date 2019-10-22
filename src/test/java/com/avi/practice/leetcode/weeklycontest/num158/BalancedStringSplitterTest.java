package com.avi.practice.leetcode.weeklycontest.num158;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BalancedStringSplitterTest {

    @Test
    public void balancedStringSplit() {
        final BalancedStringSplitter solver = new BalancedStringSplitter();
        {
            final String s = "RLRRLLRLRL";
            final int expected = 4;
            final int actual = solver.balancedStringSplit(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "RLLLLRRRLR";
            final int expected = 3;
            final int actual = solver.balancedStringSplit(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "LLLLRRRR";
            final int expected = 1;
            final int actual = solver.balancedStringSplit(s);
            Assert.assertEquals(s, expected, actual);
        }
    }
}