package com.avi.practice.leetcode.problems.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 18/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestDuplicateStringTest {
    private static final LongestDuplicateString solver = new LongestDuplicateString();

    @Test
    public void longestDupSubstring1() {
        final String s = "banana";
        final String expected = "ana";
        final String actual = solver.longestDupSubstring(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void longestDupSubstring2() {
        final String s = "abcd";
        final String expected = "";
        final String actual = solver.longestDupSubstring(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void longestDupSubstring3() {
        final String s = "abbaba";
        final String expected = "ab";
        final String actual = solver.longestDupSubstring(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void longestDupSubstring4() {
        final String s = "aabcaabdaab";
        final String expected = "aab";
        final String actual = solver.longestDupSubstring(s);
        Assert.assertEquals(s, expected, actual);
    }
}