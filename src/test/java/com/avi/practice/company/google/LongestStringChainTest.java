package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 19/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestStringChainTest {

    @Test
    public void longestStrChainAndPrintResult1() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        final int expected = 4;
        final int actual = solver.longestStrChainAndPrintResult(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResult2() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        final int expected = 5;
        final int actual = solver.longestStrChainAndPrintResult(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResult3() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"abcd","dbqca"};
        final int expected = 1;
        final int actual = solver.longestStrChainAndPrintResult(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResult4() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"bdca","bda","ca","dca","a"};
        final int expected = 4;
        final int actual = solver.longestStrChainAndPrintResult(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResult5() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        final int expected = 7;
        final int actual = solver.longestStrChainAndPrintResult(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResultV21() {
        final LongestStringChainV2 solver = new LongestStringChainV2();
        final String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        final int expected = 4;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResultV22() {
        final LongestStringChainV2 solver = new LongestStringChainV2();
        final String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        final int expected = 5;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResultV23() {
        final LongestStringChainV2 solver = new LongestStringChainV2();
        final String[] words = {"abcd","dbqca"};
        final int expected = 1;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResultV24() {
        final LongestStringChainV2 solver = new LongestStringChainV2();
        final String[] words = {"bdca","bda","ca","dca","a"};
        final int expected = 4;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResultV25() {
        final LongestStringChainV2 solver = new LongestStringChainV2();
        final String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        final int expected = 7;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChainAndPrintResultV26() {
        final LongestStringChainV2 solver = new LongestStringChainV2();
        final String[] words = {"a","b","ab","bac"};
        final int expected = 2;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }


    @Test
    public void longestStrChain1() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        final int expected = 4;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChain2() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        final int expected = 5;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChain3() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"abcd","dbqca"};
        final int expected = 1;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChain4() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"bdca","bda","ca","dca","a"};
        final int expected = 4;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChain5() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        final int expected = 7;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

    @Test
    public void longestStrChain6() {
        final LongestStringChain solver = new LongestStringChain();
        final String[] words = {"a","b","ab","bac"};
        final int expected = 2;
        final int actual = solver.longestStrChain(words);
        Assert.assertEquals(Arrays.toString(words), expected, actual);
    }

}