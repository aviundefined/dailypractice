package com.avi.practice.company.microsoft;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CalculateSentenceDifficultyTest {

    private final CalculateSentenceDifficulty solver = new CalculateSentenceDifficulty();

    @Test
    public void difficulty() {
        {
            final String str = "Difficulty of sentence";
            final int expected = 13;
            final int actual = solver.difficulty(str);
            Assert.assertEquals(str, expected, actual);
        }
        {
            final String str = "I am a geek";
            final int expected = 12;
            final int actual = solver.difficulty(str);
            Assert.assertEquals(str, expected, actual);
        }
        {
            final String str = "We are geeks";
            final int expected = 11;
            final int actual = solver.difficulty(str);
            Assert.assertEquals(str, expected, actual);
        }
    }
}