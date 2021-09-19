package com.avi.practice.leetcode.weeklycontest.num259;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestSubsequenceRepeatedKTimesTest {

    @Test
    public void longestSubsequenceRepeatedK1() {
        final LongestSubsequenceRepeatedKTimes solver = new LongestSubsequenceRepeatedKTimes();
        final String s = "letsleetcode";
        final int k = 2;
        final String expected = "let";
        final String actual = solver.longestSubsequenceRepeatedK(s, k);
        Assert.assertEquals(String.format("%s, %s", s, k), expected, actual);
    }

    @Test
    public void longestSubsequenceRepeatedK2() {
        final LongestSubsequenceRepeatedKTimes solver = new LongestSubsequenceRepeatedKTimes();
        final String s = "bb";
        final int k = 2;
        final String expected = "b";
        final String actual = solver.longestSubsequenceRepeatedK(s, k);
        Assert.assertEquals(String.format("%s, %s", s, k), expected, actual);
    }

    @Test
    public void longestSubsequenceRepeatedK3() {
        final LongestSubsequenceRepeatedKTimes solver = new LongestSubsequenceRepeatedKTimes();
        final String s = "ab";
        final int k = 2;
        final String expected = "";
        final String actual = solver.longestSubsequenceRepeatedK(s, k);
        Assert.assertEquals(String.format("%s, %s", s, k), expected, actual);
    }

    @Test
    public void longestSubsequenceRepeatedK4() {
        final LongestSubsequenceRepeatedKTimes solver = new LongestSubsequenceRepeatedKTimes();
        final String s = "bbabbabbbbabaababab";
        final int k = 3;
        final String expected = "bbbb";
        final String actual = solver.longestSubsequenceRepeatedK(s, k);
        Assert.assertEquals(String.format("%s, %s", s, k), expected, actual);
    }
}