package com.avi.practice.company.google;

import java.util.Stack;

/**
 * Created by navinash on 09/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        final Stack<Integer> nums = new Stack<>();
        final Stack<StringBuilder> expressions = new Stack<>();
        expressions.push(new StringBuilder());
        int num = 0;
        for (final char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                nums.push(num);
                expressions.push(new StringBuilder());
                num = 0;
            } else if (c == ']') {
                final int multi = nums.pop();
                final StringBuilder sb = expressions.pop();
                for (int i = 0; i < multi; i++) {
                    expressions.peek().append(sb);
                }
            } else {
                expressions.peek().append(c);
            }
        }

        return expressions.pop().toString();

    }
}
