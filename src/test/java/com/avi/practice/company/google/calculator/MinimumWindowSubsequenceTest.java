package com.avi.practice.company.google.calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 13/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumWindowSubsequenceTest {

    @Test
    public void minWindow1() {
        final MinimumWindowSubsequence solver = new MinimumWindowSubsequence();
        final String s1 = "abcdebdde";
        final String s2 = "bde";
        final String expected = "bcde";
        final String actual = solver.minWindow(s1, s2);
        Assert.assertEquals(expected, actual);
    }
}