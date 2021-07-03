package com.avi.practice.company.fb;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AlienDictionaryTest {

    private static final AlienDictionary solver = new AlienDictionary();

    @Test
    public void alienOrder1() {
        final String[] words = {"wrt","wrf","er","ett","rftt"};
        final String expected = "wertf";
        final String actual = solver.alienOrder(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void alienOrder2() {
        final String[] words = {"z","x"};
        final String expected = "zx";
        final String actual = solver.alienOrder(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void alienOrder3() {
        final String[] words = {"z","x", "z"};
        final String expected = "";
        final String actual = solver.alienOrder(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void alienOrder4() {
        final String[] words = {"z","z"};
        final String expected = "z";
        final String actual = solver.alienOrder(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void alienOrder5() {
        final String[] words = {"zy","zx"};
        final String expected = "zyx";
        final String actual = solver.alienOrder(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void alienOrder6() {
        final String[] words = {"ab","adc"};
        final String expected = "cbda";
        final String actual = solver.alienOrder(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }


    @Test
    public void alienOrder7() {
        final String[] words = {"wrt","wrtkj"};
        final String expected = "wrtkj";
        final String actual = solver.alienOrder(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }
}