package com.avi.practice.strings;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class PermutationPractice {

    final void printPermutations(final String s) {
        if (isEmpty(s)) {
            return;
        }

        final int n = s.length();
        final char[] chars = s.toCharArray();
        _printPermutations(chars, 0, n - 1);
    }


    final void printLexicographicallySortedPermutations(final String s) {
        if (s == null) {
            return;
        }
        if (s.length() <= 1) {
            System.out.println(s);
        }

        final char[] chars = s.toCharArray();
        final Map<Character, Integer> countMap = new TreeMap<>();
        for (final char c : chars) {
            countMap.compute(c, (ch, count) -> {
                if (count == null) {
                    return 1;
                }
                return count + 1;
            });
        }

        final char[] str = new char[countMap.size()];
        final int[] count = new int[countMap.size()];
        int i = 0;
        for (final Map.Entry<Character, Integer> e : countMap.entrySet()) {
            str[i] = e.getKey();
            count[i] = e.getValue();
            i++;
        }
        final char[] result = new char[s.length()];
        _printLexicographicallySortedPermutations(str, count, result, 0);
    }

    private void _printLexicographicallySortedPermutations(
            char[] str, int[] count, char[] result, int level) {
        if (level == result.length) {
            printArray(result);
        }

        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            count[i]--;
            result[level] = str[i];
            _printLexicographicallySortedPermutations(str, count, result, level + 1);
            count[i]++;
        }
    }

    private void printArray(final char[] chars) {
        for (final char c : chars) {
            System.out.print(c);
        }
        System.out.println();
    }

    private void _printPermutations(char[] chars, int l, int r) {
        if (l == r) {
            System.out.println(String.valueOf(chars));
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(chars, l, i);
            _printPermutations(chars, l + 1, r);
            swap(chars, l, i);
        }
    }

    final void swap(final char[] chars, final int l, final int r) {
        final char tmp = chars[r];
        chars[r] = chars[l];
        chars[l] = tmp;
    }

    final boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}
