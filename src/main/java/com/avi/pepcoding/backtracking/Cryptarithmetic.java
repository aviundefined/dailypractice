package com.avi.pepcoding.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by navinash on 25/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Cryptarithmetic {

    public final List<Map<Character, Integer>> solve(final String word1, final String word2, final String finalWord) {
        // word1 + word2 = finalWord
        final Set<Character> set = new TreeSet<>();
        for (final char c : word1.toLowerCase().toCharArray()) {
            set.add(c);
        }
        for (final char c : word2.toLowerCase().toCharArray()) {
            set.add(c);
        }
        for (final char c : finalWord.toLowerCase().toCharArray()) {
            set.add(c);
        }
        final List<Character> uniqueChars = new ArrayList<>(set);
        System.out.println(uniqueChars);

        final boolean[] used = new boolean[10];
        final List<Map<Character, Integer>> allMappings = new ArrayList<>();
        final Map<Character, Integer> charMap = new HashMap<>();
        // start from first char
        backtrack(0, uniqueChars, used, charMap, allMappings, word1, word2, finalWord);
        return allMappings;
    }

    private void backtrack(
            final int index,
            final List<Character> uniqueChars,
            final boolean[] used,
            final Map<Character, Integer> charMap,
            final List<Map<Character, Integer>> allMappings,
            final String word1,
            final String word2,
            final String finalWord) {
        if (index == uniqueChars.size()) {
            // check if sum of word1 + word2 = finalWord then print and return else return
            if (isValid(charMap, uniqueChars, word1, word2, finalWord)) {
                allMappings.add(new TreeMap<>(charMap));
            }
            return;
        }

        final char c = uniqueChars.get(index);
        for (int i = 0; i < used.length; i++) {
            // assign value is available
            if (!used[i]) {
                charMap.put(c, i);
                used[i] = true;
                backtrack(index + 1, uniqueChars, used, charMap, allMappings, word1, word2, finalWord);
                charMap.remove(c);
                used[i] = false;
            }
        }
    }

    private boolean isValid(
            final Map<Character, Integer> charMap,
            final List<Character> uniqueChars,
            final String word1,
            final String word2,
            final String finalWord) {
        if (charMap.size() != uniqueChars.size()) {
            return false;
        }
        final int sum1 = sum(charMap, word1);
        final int sum2 = sum(charMap, word2);
        final int finalSum = sum(charMap, finalWord);
        return (sum1 + sum2) == finalSum;
    }

    private int sum(final Map<Character, Integer> charMap, final String word) {
        int sum = 0;
        for (final char c : word.toLowerCase().toCharArray()) {
            sum += charMap.getOrDefault(c, 0);
        }
        return sum;
    }
}
