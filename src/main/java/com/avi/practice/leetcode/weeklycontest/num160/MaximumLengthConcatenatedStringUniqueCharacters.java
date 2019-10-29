package com.avi.practice.leetcode.weeklycontest.num160;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 29/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class MaximumLengthConcatenatedStringUniqueCharacters {


    public int maxLengthOptimized(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        if (arr.size() == 1) {
            return arr.get(0).length();
        }

        final Map<Integer, Integer> maxLengthByEncodedString = new HashMap<>();
        maxLengthByEncodedString.put(0, 0);
        int max = 0;
        for (final String s : arr) {
            final int bitEncoded = bitEncodeString(s);
            if (bitEncoded == -1) {
                continue;
            }
            final Map<Integer, Integer> curr = new HashMap<>();
            for (final Map.Entry<Integer, Integer> e : maxLengthByEncodedString.entrySet()) {
                if ((bitEncoded & e.getKey()) == 0) {
                    // if currents string and previous key doesn't have any common character then
                    // compute the new key with combine all characters of current encoded string and previous key
                    final int newKey = bitEncoded | e.getKey();
                    if (!maxLengthByEncodedString.containsKey(newKey)) {
                        final int newLen = s.length() + e.getValue();
                        curr.put(newKey, newLen);
                        if (newLen > max) {
                            max = newLen;
                        }
                    }
                }
            }
            maxLengthByEncodedString.putAll(curr);
        }
        return max;
    }

    private int bitEncodeString(String s) {
        int bitEncoded = 0;
        for (final char c : s.toCharArray()) {
            int index = c - 'a'; // base with 'a' so index will be in between 0 to 25
            if (((bitEncoded >> index) & 1) == 1) {
                return -1; // already exists the character
            }
            bitEncoded = bitEncoded + (1 << index); // add current character value at it's bit
        }
        return bitEncoded;
    }

    public int maxLength(final List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        if (arr.size() == 1) {
            return arr.get(0).length();
        }

        final char EMPTY_CHAR = ' ';
        final String EMPTY_STR = "";
        final Map<Integer, Map<String, Set<Character>>> permutationsByIndex = new HashMap<>();
        final Set<Character> zeroIndexChars = new HashSet<>();
        zeroIndexChars.add(EMPTY_CHAR);
        final Map<String, Set<Character>> zeroIndexPermutations = new HashMap<>();
        zeroIndexPermutations.put(EMPTY_STR, zeroIndexChars);
        permutationsByIndex.put(0, zeroIndexPermutations);

        final int n = arr.size();
        for (int i = 1; i <= n; i++) {
            final String curr = arr.get(i - 1);
            final Map<String, Set<Character>> prevIndexPermutations = permutationsByIndex.get(i - 1);
            final Map<String, Set<Character>> currIndexPermutations = new HashMap<>(prevIndexPermutations);
            final Set<Character> currChars = new HashSet<>();
            boolean acceptCurrent = true;
            for (final char c : curr.toCharArray()) {
                if (!currChars.add(c)) {
                    acceptCurrent = false;
                }
            }
            if (acceptCurrent) {
                currIndexPermutations.put(curr, currChars);
                for (final Map.Entry<String, Set<Character>> e : prevIndexPermutations.entrySet()) {
                    final Set<Character> chars = new HashSet<>(e.getValue());
                    boolean accept = true;
                    for (final char c : currChars) {
                        if (!chars.add(c)) {
                            accept = false;
                            break;
                        }
                    }
                    if (accept) {
                        currIndexPermutations.put(e.getKey() + curr, chars);
                    }
                }
            }
            permutationsByIndex.put(i, currIndexPermutations);

        }
        int max = 0;
        for (final String e : permutationsByIndex.get(n).keySet()) {
            if (e.length() > max) {
                max = e.length();
            }
        }
        return max;
    }
}
