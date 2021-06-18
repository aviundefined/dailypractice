package com.avi.practice.leetcode.problems.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 18/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestDuplicateString {

    private static final Result NOT_FOUND = new Result(false, "");

    public String longestDupSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLen = 0;
        String max = "";
        int left = 1, right = s.length();
        while (left <= right) {
            final int mid = left + (right - left) / 2;
            final Result result = search(s, mid);
            if (result.isFound) {
                if (mid > maxLen) {
                    maxLen = mid;
                    max = result.s;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    private Result search(final String s, final int length) {
        // check if substrings of length s exist in s
        final Set<String> seen = new HashSet<>();
        for (int i = 0; i < s.length() - length + 1; i++) {
            final String substring = s.substring(i, i + length);
            if (seen.contains(substring)) {
                return new Result(true, substring);
            }
            seen.add(substring);
        }

        return NOT_FOUND;
    }

    private static final class Result {
        private final boolean isFound;
        private final String s;

        public Result(boolean isFound, String s) {
            this.isFound = isFound;
            this.s = s;
        }
    }
}
