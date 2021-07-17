package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by navinash on 17/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WordSearchIITest {

    private static final WordSearchII solver = new WordSearchII();

    @Test
    public void findWords1() {
        final char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        final String[] words = {"oath", "pea", "eat", "rain"};
        for (final char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Words: " + Arrays.toString(words));
        final List<String> expected = Arrays.asList("eat", "oath");
        final List<String> actual = solver.findWords(board, words);
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}