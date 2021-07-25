package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 24/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WordLadderIITest {

    @Test
    public void findLadders1() {
        final WordLadderII solver = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        final List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("hit", "hot", "dot", "dog", "cog"));
        expected.add(Arrays.asList("hit", "hot", "lot", "log", "cog"));
        final List<List<String>> actual = solver.findLadders(beginWord, endWord, wordList);
        Assert.assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    public void findLadders2() {
        final WordLadderII solver = new WordLadderII();
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
        final List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("red", "ted", "tad", "tax"));
        expected.add(Arrays.asList("red", "ted", "tex", "tax"));
        expected.add(Arrays.asList("red", "rex", "tex", "tax"));
        final List<List<String>> actual = solver.findLadders(beginWord, endWord, wordList);
        Assert.assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

}