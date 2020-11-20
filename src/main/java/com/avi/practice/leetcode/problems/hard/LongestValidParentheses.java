package com.avi.practice.leetcode.problems.hard;

import java.util.Stack;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestValidParentheses {

    public int longestValidParenthesesDP(final String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        final char[] chars = s.toCharArray();
        int max = 0;
        final int[] dp = new int[chars.length];
        dp[0] = 0;
        if (chars[0] == '(' && chars[1] == ')') {
            dp[1] = 2;
            max = 2;
        }
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == ')' && chars[i - 1] == '(') {
                // (())(->)
                // dp[i] = dp[i-2] + 2
                dp[i] = dp[i - 2] + 2;
            } else if (chars[i] == ')' && chars[i - 1] == ')') {
                final int j = i - dp[i - 1] - 1;
                if (j >= 0 && chars[j] == '(') {
                    // ()((()))->)
                    // dp[i] = 2 + dp[i-1] + dp[i - dp[i-1] - 2]
                    dp[i] = 2 + dp[i - 1];
                    if (j - 1 >= 0) {
                        dp[i] += dp[j - 1];
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public int longestValidParenthesesBruteForce(final String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        final char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j += 2) {
                if (isValid(chars, i, j)) {
                    if (max < (j - i + 1)) {
                        max = j - i + 1;
                    }
                }
            }
        }
        return max;
    }

    private static boolean isValid(final char[] chars, int start, int end) {
        final Stack<Character> s = new Stack<>();
        for (int i = start; i <= end; i++) {
            final char c = chars[i];
            if (c == '(') {
                s.push(c);
            } else if (!s.isEmpty() && s.peek() == '(') {
                s.pop();
            } else {
                return false;
            }

        }
        return s.isEmpty();
    }
}
