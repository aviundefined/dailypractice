package com.avi.practice.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 18/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestRepeatingSubstring {

    private static final long BASE = 26L;


    public int longestRepeatingSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int left = 1, right = s.length();
        while (left <= right) {
            final int mid = left + (right - left) / 2;
            if (search(s, mid)) {
                if (mid > maxLen) {
                    maxLen = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxLen;
    }

    private boolean search(final String s, final int length) {
        // check if substrings of length s exist in s
        final Set<String> seen = new HashSet<>();
        for (int i = 0; i < s.length() - length + 1; i++) {
            final String substring = s.substring(i, i + length);
            if (seen.contains(substring)) {
                return true;
            }
            seen.add(substring);
        }
        return false;
    }

    public int longestRepeatingSubstringTLE(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); i++, j++) {
                final String pattern = s.substring(i, j + 1);
                final String str = s.substring(i + 1);
                if (rabinKarp(str, pattern) && (j - i + 1) > maxLen) {
                    maxLen = (j - i + 1);
                }
            }
        }
        return maxLen;
    }

    final boolean rabinKarp(final String s, final String pattern) {
        final long hash = hashCode(pattern.toCharArray());
        final int patternLen = pattern.length();
        char[] chars = new char[patternLen];
        long slidingHashCode = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (i < patternLen) {
                chars[i] = s.charAt(i);
            }
            if (i < patternLen - 1) {
                continue;
            } else if (i == patternLen - 1) {
                slidingHashCode = hashCode(chars);
            } else {
                final long v1 = (long) Math.pow(BASE, patternLen - 1) * (s.charAt(i - patternLen) - 'a');
                final long v2 = (slidingHashCode - v1);
                slidingHashCode = v2 * BASE + (s.charAt(i) - 'a');
            }
            if (slidingHashCode == hash) {
                if (match(s, pattern, patternLen, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean match(String s, String pattern, int patternLen, int i) {
        // match the characters
        // s -> (i - patternLen + 1, i)
        for (int k = 0, l = i - patternLen + 1; k < patternLen; k++, l++) {
            if (pattern.charAt(k) != s.charAt(l)) {
                return false;
            }
        }
        return true;
    }

    private long hashCode(char[] chars) {
        long hash = 0L;
        final int n = chars.length;
        for (int i = n - 1; i >= 0; i--) {
            final long val = (long) ((chars[i] - 'a') * Math.pow(BASE, n - i - 1));
            hash += val;
        }
        return hash;
    }
}
