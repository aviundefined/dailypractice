package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class NumberMatchingSubsequencesTest {

    @Test
    public void numMatchingSubseq1() {
        final NumberMatchingSubsequences solver = new NumberMatchingSubsequences();
        final String s = "abcde";
        final String[] words = {"a", "bb", "acd", "ace"};
        final int expected = 3;
        final int actual = solver.numMatchingSubseq(s, words);
        Assert.assertEquals(String.format("s: %s, words: %s", s, Arrays.toString(words)), expected, actual);
    }

    @Test
    public void numMatchingSubseq_BruteFroce1() {
        final NumberMatchingSubsequences solver = new NumberMatchingSubsequences();
        final String s = "abcde";
        final String[] words = {"a", "bb", "acd", "ace"};
        final int expected = 3;
        final int actual = solver.numMatchingSubseq_BruteFroce(s, words);
        Assert.assertEquals(String.format("s: %s, words: %s", s, Arrays.toString(words)), expected, actual);
    }
}