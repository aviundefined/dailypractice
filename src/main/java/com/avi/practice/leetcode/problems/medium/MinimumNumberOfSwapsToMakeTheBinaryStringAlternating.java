package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 19/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {

    public int minSwaps(final String s) {
        int numZeros = 0;
        int numOnes = 0;
        final char[] chars = s.toCharArray();
        for (final char c : chars) {
            switch (c) {
                case '0':
                    numZeros++;
                    break;
                case '1':
                    numOnes++;
                    break;
                default:
                    throw new IllegalArgumentException("Please provide valid binary string: " + s);
            }
        }

        if (Math.abs(numOnes - numZeros) > 1) {
            return -1; // not possible
        }

        if (Math.abs(numOnes - numZeros) == 1) {
            if (numOnes > numZeros) {
                // that means valid string start with 1
                return helper(chars, generateValidString('1', s.length()));
            } else {
                // that means valid string start with 1
                return helper(chars, generateValidString('0', s.length()));
            }
        }

        final int c1 = helper(chars, generateValidString('1', s.length()));
        final int c2 = helper(chars, generateValidString('0', s.length()));
        return Math.min(c1, c2);
    }

    private char[] generateValidString(final char start, final int length) {
        final char[] chars = new char[length];
        chars[0] = start;

        char next = start == '1' ? '0' : '1';
        for (int i = 1; i < length; i++) {
            chars[i] = next;
            next = next == '1' ? '0' : '1';
        }
        return chars;
    }

    private int helper(final char[] original, final char[] expected) {
        int misMatch = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != expected[i]) {
                misMatch++;
            }
        }
        return misMatch / 2;
    }
}
