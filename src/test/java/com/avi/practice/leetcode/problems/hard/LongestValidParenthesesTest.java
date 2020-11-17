package com.avi.practice.leetcode.problems.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestValidParenthesesTest {
    private static final LongestValidParentheses solver = new LongestValidParentheses();

    @Test
    public void longestValidParenthesesBruteForce() {
        {
            final String s = "(()";
            final int expected = 2;
            final int actual = solver.longestValidParenthesesBruteForce(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = ")()())";
            final int expected = 4;
            final int actual = solver.longestValidParenthesesBruteForce(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "";
            final int expected = 0;
            final int actual = solver.longestValidParenthesesBruteForce(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "))";
            final int expected = 0;
            final int actual = solver.longestValidParenthesesBruteForce(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "((";
            final int expected = 0;
            final int actual = solver.longestValidParenthesesBruteForce(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "()";
            final int expected = 2;
            final int actual = solver.longestValidParenthesesBruteForce(s);
            Assert.assertEquals(s, expected, actual);
        }
    }

    @Test
    public void longestValidParenthesesDP() {
        {
            final String s = "(()";
            final int expected = 2;
            final int actual = solver.longestValidParenthesesDP(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = ")()())";
            final int expected = 4;
            final int actual = solver.longestValidParenthesesDP(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "";
            final int expected = 0;
            final int actual = solver.longestValidParenthesesDP(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "))";
            final int expected = 0;
            final int actual = solver.longestValidParenthesesDP(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "((";
            final int expected = 0;
            final int actual = solver.longestValidParenthesesDP(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "()";
            final int expected = 2;
            final int actual = solver.longestValidParenthesesDP(s);
            Assert.assertEquals(s, expected, actual);
        }
    }


}