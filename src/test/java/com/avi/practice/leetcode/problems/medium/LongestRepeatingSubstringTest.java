package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 18/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestRepeatingSubstringTest {

    private static final LongestRepeatingSubstring solver  = new LongestRepeatingSubstring();


    @Test
    public void longestRepeatingSubstring1() {
        final String s = "abbaba";
        final int expected = 2;
        final int actual = solver.longestRepeatingSubstring(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void longestRepeatingSubstring2() {
        final String s = "aabcaabdaab";
        final int expected = 3;
        final int actual = solver.longestRepeatingSubstring(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void longestRepeatingSubstringTLE1() {
        final String s = "abbaba";
        final int expected = 2;
        final int actual = solver.longestRepeatingSubstringTLE(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void longestRepeatingSubstringTLE2() {
        final String s = "aabcaabdaab";
        final int expected = 3;
        final int actual = solver.longestRepeatingSubstringTLE(s);
        Assert.assertEquals(s, expected, actual);
    }

    @Test
    public void rabinKarp1() {
        final String s = "abbaba";
        final String pattern = "bab";
        final boolean expected = true;
        final boolean actual = solver.rabinKarp(s, pattern);
        Assert.assertEquals(String.format("%s, %s", s, pattern), expected, actual);
    }

    @Test
    public void rabinKarp2() {
        final String s = "abbabac";
        final String pattern = "ab";
        final boolean expected = true;
        final boolean actual = solver.rabinKarp(s, pattern);
        Assert.assertEquals(String.format("%s, %s", s, pattern), expected, actual);
    }

    @Test
    public void rabinKarp3() {
        final String s = "abbaba";
        final String pattern = "abcd";
        final boolean expected = false;
        final boolean actual = solver.rabinKarp(s, pattern);
        Assert.assertEquals(String.format("%s, %s", s, pattern), expected, actual);
    }
}