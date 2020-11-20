package com.avi.practice.leetcode.problems.hard;

import java.util.Stack;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ValidParentheses {


    private static boolean isValid(final char[] chars, int start, int end) {
        final Stack<Character> s = new Stack<>();
        for (int i = start; i <= end; i++) {
            final char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                s.push(c);
                continue;
            }
            if (s.isEmpty()) {
                return false;
            }
            final char pop = s.pop();
            if ((c == ']' && pop != '[')
                    || (c == '}' && pop != '{')
                    || (c == ')' && pop != '(')) {
                return false;
            }
        }
        return s.isEmpty();
    }
}
