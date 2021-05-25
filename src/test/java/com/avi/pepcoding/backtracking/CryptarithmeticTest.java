package com.avi.pepcoding.backtracking;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CryptarithmeticTest {
    private static final Cryptarithmetic solver = new Cryptarithmetic();

    @Test
    public void solve1() {
        final String word1 = "send";
        final String word2 = "more";
        final String finalWord = "money";
        final List<Map<Character, Integer>> allMappings = solver.solve(word1, word2, finalWord);
        for(final Map<Character, Integer> mapping : allMappings) {
            System.out.println(mapping);
            System.out.println("------------");
        }
    }
}