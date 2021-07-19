package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 18/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConcatenatedWordsTest {

    @Test
    public void findAllConcatenatedWordsInADict1() {
        final ConcatenatedWords solver = new ConcatenatedWords();
        final String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        final List<String> expected = Arrays.asList("catsdogcats","dogcatsdog","ratcatdogcat");
        final List<String> actual = solver.findAllConcatenatedWordsInADict(words);
        Assert.assertEquals(expected, actual);
    }
}