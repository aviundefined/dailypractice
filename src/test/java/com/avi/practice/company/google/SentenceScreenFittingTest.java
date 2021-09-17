package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 25/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SentenceScreenFittingTest {

    private static final SentenceScreenFitting solver = new SentenceScreenFitting();

    @Test
    public void wordsTyping1() {
        final String[] sentence = {"hello", "world"};
        final int rows = 2;
        final int cols = 8;
        final int expected =    1;
        final int actual = solver.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(String.format("%s, %d, %d", Arrays.toString(sentence), rows, cols), expected, actual);
    }


    @Test
    public void wordsTyping2() {
        final String[] sentence = {"a", "bcd", "e"};
        final int rows = 3;
        final int cols = 6;
        final int expected =    2;
        final int actual = solver.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(String.format("%s, %d, %d", Arrays.toString(sentence), rows, cols), expected, actual);
    }

    @Test
    public void wordsTyping3() {
        final String[] sentence = {"i","had","apple","pie"};
        final int rows = 4;
        final int cols = 5;
        final int expected =    1;
        final int actual = solver.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(String.format("%s, %d, %d", Arrays.toString(sentence), rows, cols), expected, actual);
    }

    @Test
    public void wordsTyping4() {
        final String[] sentence = {"hello", "world"};
        final int rows = 6;
        final int cols = 8;
        final int expected =  3;
        final int actual = solver.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(String.format("%s, %d, %d", Arrays.toString(sentence), rows, cols), expected, actual);
    }

    @Test
    public void wordsTyping5() {
        final String[] sentence = {"a","bcd"};
        final int rows = 20000;
        final int cols = 20000;
        final int expected =  66660000;
        final int actual = solver.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(String.format("%s, %d, %d", Arrays.toString(sentence), rows, cols), expected, actual);
    }

    @Test
    public void wordsTyping6() {
        final String[] sentence = {"f","p", "a"};
        final int rows = 8;
        final int cols = 7;
        final int expected =  10;
        final int actual = solver.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(String.format("%s, %d, %d", Arrays.toString(sentence), rows, cols), expected, actual);
    }

    @Test
    public void wordsTyping7() {
        final String[] sentence = {"try","to", "be", "better"};
        final int rows = 10;
        final int cols = 91;
        final int expected =  53;
        final int actual = solver.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(String.format("%s, %d, %d", Arrays.toString(sentence), rows, cols), expected, actual);
    }
}