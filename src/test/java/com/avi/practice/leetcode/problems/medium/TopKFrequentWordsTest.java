package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TopKFrequentWordsTest {

    private static final TopKFrequentWords solver = new TopKFrequentWords();

    @Test
    public void topKFrequent1() {
        final String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        final int k = 2;
        final List<String> expected = Arrays.asList("i", "love");
        final List<String> actual = solver.topKFrequent(words, k);
        System.out.println("Expected: "+expected);
        System.out.println("Actual: "+actual);
        Assert.assertEquals(expected, actual);
        System.out.println("--------------");
    }

    @Test
    public void topKFrequent2() {
        final String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        final int k = 4;
        final List<String> expected = Arrays.asList("the","is","sunny","day");
        final List<String> actual = solver.topKFrequent(words, k);
        System.out.println("Expected: "+expected);
        System.out.println("Actual: "+actual);
        Assert.assertEquals(expected, actual);
        System.out.println("--------------");
    }
}