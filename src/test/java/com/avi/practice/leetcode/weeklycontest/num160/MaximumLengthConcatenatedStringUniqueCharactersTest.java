package com.avi.practice.leetcode.weeklycontest.num160;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by navinash on 29/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumLengthConcatenatedStringUniqueCharactersTest {

    @Test
    public void maxLength() {
        final MaximumLengthConcatenatedStringUniqueCharacters solver = new MaximumLengthConcatenatedStringUniqueCharacters();
        {
            final List<String> arr = Arrays.asList("un", "iq", "ue");
            final int expected = 4;
            final int actual = solver.maxLength(arr);
            final int actualOptimized = solver.maxLengthOptimized(arr);
            Assert.assertEquals(arr.toString(), expected, actual);
            Assert.assertEquals(arr.toString(), expected, actualOptimized);
        }
        {
            final List<String> arr = Arrays.asList("cha", "r", "act", "ers");
            final int expected = 6;
            final int actual = solver.maxLength(arr);
            final int actualOptimized = solver.maxLengthOptimized(arr);
            Assert.assertEquals(arr.toString(), expected, actual);
            Assert.assertEquals(arr.toString(), expected, actualOptimized);
        }
        {
            final List<String> arr = Collections.singletonList("abcdefghijklmnopqrstuvwxyz");
            final int expected = 26;
            final int actual = solver.maxLength(arr);
            final int actualOptimized = solver.maxLengthOptimized(arr);
            Assert.assertEquals(arr.toString(), expected, actual);
            Assert.assertEquals(arr.toString(), expected, actualOptimized);
        }
        {
            final List<String> arr = Arrays.asList("abcdefghijklmnopqrstuvwxyz", "bc");
            final int expected = 26;
            final int actual = solver.maxLength(arr);
            final int actualOptimized = solver.maxLengthOptimized(arr);
            Assert.assertEquals(arr.toString(), expected, actual);
            Assert.assertEquals(arr.toString(), expected, actualOptimized);
        }
        {
            final List<String> arr = Arrays.asList("ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij", "ji", "kl", "lk", "mn", "nm", "op", "po");
            final int expected = 16;
            final int actual = solver.maxLength(arr);
            final int actualOptimized = solver.maxLengthOptimized(arr);
            Assert.assertEquals(arr.toString(), expected, actual);
            Assert.assertEquals(arr.toString(), expected, actualOptimized);
        }
        {
            final List<String> arr = Arrays.asList("yy", "bkhwmpbiisbldzknpm");
            final int expected = 0;
            final int actual = solver.maxLength(arr);
            final int actualOptimized = solver.maxLengthOptimized(arr);
            Assert.assertEquals(arr.toString(), expected, actual);
            Assert.assertEquals(arr.toString(), expected, actualOptimized);
        }
    }
}