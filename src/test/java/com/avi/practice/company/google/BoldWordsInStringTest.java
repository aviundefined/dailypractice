package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 06/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BoldWordsInStringTest {

    @Test
    public void boldWords1() {
        final BoldWordsInString solver = new BoldWordsInString();
        final String[] words = {"ab","bc"};
        final String s = "aabcd";
        final String expected = "a<b>abc</b>d";
        final String actual = solver.boldWords(words, s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void boldWords2() {
        final BoldWordsInString solver = new BoldWordsInString();
        final String[] words = {"ccb","b","d","cba","dc"};
        final String s = "eeaadadadc";
        final String expected = "eeaa<b>d</b>a<b>d</b>a<b>dc</b>";
        final String actual = solver.boldWords(words, s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void boldWords3() {
        final BoldWordsInString solver = new BoldWordsInString();
        final String[] words = {"ccb","b","d","cba","dc"};
        final String s = "eeaadadadc";
        final String expected = "eeaa<b>d</b>a<b>d</b>a<b>dc</b>";
        final String actual = solver.boldWords(words, s);
        Assert.assertEquals(expected, actual);
    }

}