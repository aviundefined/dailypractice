package com.avi.practice.company.google;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 17/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AutocompleteSystemTest {

    @Test
    public void input1() {
        final String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        final int[] times = {5, 3, 2, 2};
        final AutocompleteSystem solver = new AutocompleteSystem(sentences, times);
        Assert.assertEquals(Lists.newArrayList("i love you", "island", "i love leetcode") , solver.input('i'));
        Assert.assertEquals(Lists.newArrayList("i love you", "i love leetcode") , solver.input(' '));
        Assert.assertEquals(Lists.newArrayList() , solver.input('a'));
        Assert.assertEquals(Lists.newArrayList() , solver.input('#'));
    }

    @Test
    public void input2() {
        final String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        final int[] times = {5, 3, 2, 2};
        final AutocompleteSystem solver = new AutocompleteSystem(sentences, times);
        Assert.assertEquals(Lists.newArrayList("i love you", "island", "i love leetcode") , solver.input('i'));
        Assert.assertEquals(Lists.newArrayList("i love you", "i love leetcode") , solver.input(' '));
        Assert.assertEquals(Lists.newArrayList() , solver.input('a'));
        Assert.assertEquals(Lists.newArrayList() , solver.input('#'));
        Assert.assertEquals(Lists.newArrayList("i love you", "island", "i love leetcode") , solver.input('i'));
        Assert.assertEquals(Lists.newArrayList("i love you", "i love leetcode", "i a") , solver.input(' '));
        Assert.assertEquals(Lists.newArrayList("i a") , solver.input('a'));
        Assert.assertEquals(Lists.newArrayList() , solver.input('#'));
        Assert.assertEquals(Lists.newArrayList("i love you", "island", "i a") , solver.input('i'));
        Assert.assertEquals(Lists.newArrayList("i love you", "i a", "i love leetcode") , solver.input(' '));
        Assert.assertEquals(Lists.newArrayList("i a") , solver.input('a'));
        Assert.assertEquals(Lists.newArrayList() , solver.input('#'));
    }
}