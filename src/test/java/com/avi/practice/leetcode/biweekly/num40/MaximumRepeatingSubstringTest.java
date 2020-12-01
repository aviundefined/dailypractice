package com.avi.practice.leetcode.biweekly.num40;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumRepeatingSubstringTest {

    private static final MaximumRepeatingSubstring solver = new MaximumRepeatingSubstring();

    @Test
    public void maxRepeating1() {
        final String sequence = "ababc";
        final String word = "ab";
        final int expected = 2;
        final int actual = solver.maxRepeating(sequence, word);
        Assert.assertEquals(String.format("sequence: %s, word: %s", sequence, word), expected, actual);
    }


    @Test
    public void maxRepeating2() {
        final String sequence = "ababc";
        final String word = "ba";
        final int expected = 1;
        final int actual = solver.maxRepeating(sequence, word);
        Assert.assertEquals(String.format("sequence: %s, word: %s", sequence, word), expected, actual);
    }


    @Test
    public void maxRepeating3() {
        final String sequence = "ababc";
        final String word = "ac";
        final int expected = 0;
        final int actual = solver.maxRepeating(sequence, word);
        Assert.assertEquals(String.format("sequence: %s, word: %s", sequence, word), expected, actual);
    }

    @Test
    public void maxRepeating4() {
        final String sequence = "caaaa";
        final String word = "a";
        final int expected = 4;
        final int actual = solver.maxRepeating(sequence, word);
        Assert.assertEquals(String.format("sequence: %s, word: %s", sequence, word), expected, actual);
    }


}