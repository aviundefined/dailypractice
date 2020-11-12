package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StringToInteger_Problem_8 {

    public int myAtoi(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        s = s.trim();
        Sign sign = Sign.NONE;
        final char[] chars = s.toCharArray();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            final char c = chars[i];
            if (i == 0 && isPlusMinus(c)) {
                if (c == '+') {
                    sign = Sign.PLUS;
                } else if (c == '-') {
                    sign = Sign.MINUS;
                }
                continue;
            }
            if (i > 0 && isPlusMinus(c)) {
                break;
            }
            if (!isDigit(c)) {
                break;
            }
            sb.append(c);
        }
        final String numStr = sb.toString();
        if ("".equals(numStr) || numStr.trim().length() == 0) {
            return 0;
        }
        try {
            final long l = Long.parseLong(numStr);
            if (sign == Sign.MINUS) {
                final long num = l * -1L;
                if (num < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else {
                    return (int) (num);
                }
            } else {
                if (l > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return (int) (l);
                }
            }
        } catch (final Exception e) {
            System.out.printf("Number format exception: %s", numStr);
        }
        if (sign == Sign.MINUS) {
            return Integer.MIN_VALUE;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private static boolean isPlusMinus(final char c) {
        return (c == '+' || c == '-');
    }

    private static boolean isDigit(final char c) {
        return (c >= '0' && c <= '9');
    }

    private enum Sign {
        PLUS,
        MINUS,
        NONE
    }
}
