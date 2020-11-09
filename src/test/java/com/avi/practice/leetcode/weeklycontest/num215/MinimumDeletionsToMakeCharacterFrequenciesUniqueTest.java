package com.avi.practice.leetcode.weeklycontest.num215;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 09/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUniqueTest {

    private final MinimumDeletionsToMakeCharacterFrequenciesUnique solver = new MinimumDeletionsToMakeCharacterFrequenciesUnique();

    @Test
    public void minDeletions() {
        {
            final String s = "aab";
            final int expected = 0;
            final int actual = solver.minDeletions(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "aaabbbcc";
            final int expected = 2;
            final int actual = solver.minDeletions(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "ceabaacb";
            final int expected = 2;
            final int actual = solver.minDeletions(s);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final String s = "aaaaaaaaaaabbbbcccdde";
            final int expected = 0;
            final int actual = solver.minDeletions(s);
            Assert.assertEquals(s, expected, actual);
        }
    }
}