package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TextJustificationTest {

    private static final TextJustification solver = new TextJustification();

    @Test
    public void fullJustify1() {
        final String[] words = {"Tushar", "Roy", "loves", "to", "code"};
        final int maxWidth  = 10;
        final List<String> expected = Arrays.asList("Tushar", "Roy loves", "to code");
        final List<String> actual = solver.fullJustify(words, maxWidth);
        System.out.println(actual);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void fullJustify2() {
        final String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        final int maxWidth  = 16;
        final List<String> expected = Arrays.asList("This    is    an", "example  of text", "justification.  ");
        final List<String> actual = solver.fullJustify(words, maxWidth);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void fullJustify3() {
        final String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        final int maxWidth  = 16;
        final List<String> expected = Arrays.asList("This    is    an", "example  of text", "justification.  ");
        final List<String> actual = solver.fullJustify(words, maxWidth);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }
}