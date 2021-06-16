package com.avi.practice.company.google;

import java.util.Stack;

/**
 * Created by navinash on 09/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DecodeString {

    private static boolean isDigit(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String decodeString(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }

        final Stack<String> s = new Stack<>();
        for (final char c : str.toLowerCase().toCharArray()) {
            if (!"]".equals(String.valueOf(c))) {
                s.push(String.valueOf(c));
                continue;
            }

            final Stack<String> sb = new Stack<>();
            while (!s.isEmpty()) {
                final String curr = s.pop();
                if (curr.equals("[")) {
                    break;
                }
                sb.push(curr);
            }

            int multi = 1;
            int k = 0;
            while (!s.isEmpty()) {
                final String curr = s.peek();
                if (!isDigit(curr)) {
                    break;
                }
                k = (Integer.parseInt(String.valueOf(curr)) + k) * multi;
                multi = multi * 10;
                s.pop();
            }
            final StringBuilder pt = new StringBuilder();
            while (!sb.isEmpty()) {
                pt.append(sb.pop());
            }
            for (int i = 0; i < k; i++) {
                s.push(pt.toString());
            }
        }


        final Stack<String> reverse = new Stack<>();
        while (!s.isEmpty()) {
            reverse.push(s.pop());
        }
        final StringBuilder result = new StringBuilder();
        while (!reverse.isEmpty()) {
            result.append(reverse.pop());
        }
        return result.toString();
    }
}
