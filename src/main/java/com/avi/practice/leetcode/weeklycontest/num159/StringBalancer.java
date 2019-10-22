package com.avi.practice.leetcode.weeklycontest.num159;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class StringBalancer {

    private Map<Character, Integer> init(final char[] chars) {
        final int n = chars.length;
        if (n % 4 != 0) {
            throw new RuntimeException("Invalid argument:: String length should be multiple of 4. Length: " + n);
        }
        final Map<Character, Integer> frequency = new HashMap<>();
        final Set<Character> ALLOWED = new HashSet<>();
        ALLOWED.add('Q');
        ALLOWED.add('W');
        ALLOWED.add('E');
        ALLOWED.add('R');
        for (final char c : chars) {
            if (!ALLOWED.contains(c)) {
                throw new RuntimeException(String.format("Invalid argument:: String should only contain [%s], but it has [%s]", ALLOWED, c));
            }
            frequency.compute(c, (character, existing) -> {
                if (existing == null) {
                    return 1;
                }
                return existing + 1;
            });
        }
        final int expected = n / 4;
        final Map<Character, Integer> extras = new HashMap<>();
        for (final Map.Entry<Character, Integer> e : frequency.entrySet()) {
            if (e.getValue() > expected) {
                extras.put(e.getKey(), e.getValue() - expected);
            }
        }
        System.out.println("extras: " + extras);
        return extras;
    }

    final int minReplacements(final String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        final char[] chars = s.toUpperCase().toCharArray();
        final Map<Character, Integer> extras = init(chars);
        if (extras.size() == 0) {
            return 0;
        }
        return min(chars, extras);
    }

    private int min(final char[] chars, final Map<Character, Integer> frequency) {
        int s = 0, e = -1, min = Integer.MAX_VALUE;
        while (e < chars.length) {
            e++;
            if (e == chars.length) {
                break;
            }
            if (!isFound(frequency)) {
                final char curr = chars[e];
                if (frequency.containsKey(curr)) {
                    final int freq = frequency.get(curr);
                    frequency.put(curr, freq - 1);
                }
            }
            while (isFound(frequency) && s <= e) {
                if (e - s + 1 < min) {
                    min = e - s + 1;
                }
                final char remove = chars[s];
                if (frequency.containsKey(remove)) {
                    final int freq = frequency.get(remove);
                    frequency.put(remove, freq + 1);
                }
                s++;
            }
        }
        return min;
    }

    private boolean isFound(Map<Character, Integer> frequency) {
        for (final int val : frequency.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }
}
