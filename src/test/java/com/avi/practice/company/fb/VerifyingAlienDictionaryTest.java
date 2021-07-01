package com.avi.practice.company.fb;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class VerifyingAlienDictionaryTest {

    @Test
    public void isAlienSorted1() {
        final VerifyingAlienDictionary solver = new VerifyingAlienDictionary();
        final String[] words = {"hello","leetcode"};
        final String order = "hlabcdefgijkmnopqrstuvwxyz";
        final boolean actual = true;
        final boolean expected = solver.isAlienSorted(words, order);
        Assert.assertEquals(String.format("words: %s, order: %s", Arrays.toString(words), order), actual, expected);
    }

    @Test
    public void isAlienSorted2() {
        final VerifyingAlienDictionary solver = new VerifyingAlienDictionary();
        final String[] words = {"word","world","row"};
        final String order = "worldabcefghijkmnpqstuvxyz";
        final boolean actual = false;
        final boolean expected = solver.isAlienSorted(words, order);
        Assert.assertEquals(String.format("words: %s, order: %s", Arrays.toString(words), order), actual, expected);
    }

    @Test
    public void isAlienSorted3() {
        final VerifyingAlienDictionary solver = new VerifyingAlienDictionary();
        final String[] words = {"apple","app"};
        final String order = "abcdefghijklmnopqrstuvwxyz";
        final boolean actual = false;
        final boolean expected = solver.isAlienSorted(words, order);
        Assert.assertEquals(String.format("words: %s, order: %s", Arrays.toString(words), order), actual, expected);
    }

    @Test
    public void isAlienSorted4() {
        final VerifyingAlienDictionary solver = new VerifyingAlienDictionary();
        final String[] words = {"kuvp","q"};
        final String order = "ngxlkthsjuoqcpavbfdermiywz";
        final boolean actual = true;
        final boolean expected = solver.isAlienSorted(words, order);
        Assert.assertEquals(String.format("words: %s, order: %s", Arrays.toString(words), order), actual, expected);
    }
}