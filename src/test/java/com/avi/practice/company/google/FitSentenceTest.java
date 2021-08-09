package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 09/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FitSentenceTest {

    @Test
    public void lines1() {
        final FitSentence solver = new FitSentence();
        final String text = "my name is avinash nigam";
        final int width = 9;
        final int expected = 4;
        final int actual = solver.lines(text, width);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void lines2() {
        final FitSentence solver = new FitSentence();
        final String text = "my name is jital patel";
        final int width = 9;
        final int expected = 3;
        final int actual = solver.lines(text, width);
        Assert.assertEquals(expected, actual);
    }
}