package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StringToInteger_Problem_8Test {

    private static final StringToInteger_Problem_8 solver = new StringToInteger_Problem_8();

    @Test
    public void myAtoi() {

        {
            final String s = "+-12";
            final int expected = 0;
            final int actual = solver.myAtoi(s);
            Assert.assertEquals(s, expected, actual);
        }

        {
            final String s = "+0 12";
            final int expected = 0;
            final int actual = solver.myAtoi(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "20000000000000000000";
            final int expected = 0;
            final int actual = solver.myAtoi(s);
            Assert.assertEquals(s, expected, actual);
        }
    }
}