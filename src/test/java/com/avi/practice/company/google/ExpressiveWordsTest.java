package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressiveWordsTest {

    @Test
    public void expressiveWords1() {
        final ExpressiveWords solver = new ExpressiveWords();
        final String s = "heeellooo";
        final String[] words = {"hello", "hi", "helo"};
        final int expected = 1;
        final int actual = solver.expressiveWords(s, words);
        Assert.assertEquals(String.format("%s, %s", s, Arrays.toString(words)), expected, actual);
    }
}