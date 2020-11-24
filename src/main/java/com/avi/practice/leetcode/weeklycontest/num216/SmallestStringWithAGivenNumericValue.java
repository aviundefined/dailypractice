package com.avi.practice.leetcode.weeklycontest.num216;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 23/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 * <p>
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 * <p>
 * You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 * <p>
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, k = 27
 * Output: "aay"
 * Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
 * Example 2:
 * <p>
 * Input: n = 5, k = 73
 * Output: "aaszz"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 105
 * n <= k <= 26 * n
 */
public class SmallestStringWithAGivenNumericValue {

    private static final Map<Integer, Character> CHARS = new HashMap<>();

    static {
        char c = 'a';
        for (int i = 1; i <= 26; i++) {
            CHARS.put(i, c);
            c++;
        }
    }

    public String getSmallestString(int n, int k) {
        final int[] a = new int[n];
        Arrays.fill(a, 1);
        k = k - n;
        if (k == 0) {
            return convert(a);
        }
        int ptr = n - 1;
        while (k > 0 & ptr >= 0) {
            if (k < 26) {
                final int tmp = a[ptr];
                a[ptr] = k + tmp;
                break;
            }
            k = k + a[ptr] - 26;
            a[ptr] = 26;
            ptr--;
        }
        return convert(a);
    }

    private String convert(final int[] a) {
        final StringBuilder result = new StringBuilder();
        for (final int s : a) {
            result.append(CHARS.get(s));
        }
        return result.toString();
    }

}
