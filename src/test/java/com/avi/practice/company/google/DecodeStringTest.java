package com.avi.practice.company.google;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 09/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DecodeStringTest {

    private static final DecodeString solver = new DecodeString();

    @Test
    public void decodeString1() {
        final String str  = "3[a]2[bc]";
        final String expected = "aaabcbc";
        final String actual = solver.decodeString(str);
        Assert.assertEquals(str, expected, actual);
    }

    @Test
    public void decodeString2() {
        final String str  = "3[a2[c]]";
        final String expected = "accaccacc";
        final String actual = solver.decodeString(str);
        Assert.assertEquals(str, expected, actual);
    }

    @Test
    public void decodeString3() {
        final String str  = "2[abc]3[cd]ef";
        final String expected = "abcabccdcdcdef";
        final String actual = solver.decodeString(str);
        Assert.assertEquals(str, expected, actual);
    }

    @Test
    public void decodeString4() {
        final String str  = "abc3[cd]xyz";
        final String expected = "abccdcdcdxyz";
        final String actual = solver.decodeString(str);
        Assert.assertEquals(str, expected, actual);
    }

    @Test
    public void decodeString5() {
        final String str  = "10[a]";
        final String expected = "aaaaaaaaaa";
        final String actual = solver.decodeString(str);
        Assert.assertEquals(str, expected, actual);
    }

}