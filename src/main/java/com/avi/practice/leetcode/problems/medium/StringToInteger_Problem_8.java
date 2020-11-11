package com.avi.practice.leetcode.problems.medium;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StringToInteger_Problem_8 {

    public int myAtoi(String s) {
        if(s == null || s.trim().length() == 0) {
            return 0;
        }

        s = s.replaceAll("\\s", "");
        boolean isNegative = false;
        boolean isSignFound = false;
        boolean isDigitFound = false;
        final char[] chars = s.toCharArray();
        final StringBuilder sb = new StringBuilder();
        for(final char c : chars) {
            if(isSignFound && isPlusMinus(c)) {
                break;
            }
            if(isDigitFound &&  isPlusMinus(c)) {
                break;
            }
            if(c == '-') {
                isNegative = true;
                isSignFound = true;
                continue;
            }
            if (c == '+') {
                isNegative = false;
                isSignFound = true;
                continue;
            }
            if (isDigit(c)) {
                sb.append(c);
                isDigitFound = true;
                continue;
            }else if(c == ' ') {
                continue;
            }
            break;
        }
        final String numStr = sb.toString();
        if("".equals(numStr) || numStr.trim().length() == 0) {
            return 0;
        }
        final long l = Long.parseLong(numStr);
        if(isNegative) {
            final long num = l * -1L;
            if(num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }else{
                return (int) (num);
            }
        }else{
            if(l > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }else{
                return (int) (l);
            }
        }
    }

    private static boolean isPlusMinus(final char c) {
        return (c == '+' || c == '-');
    }

    private static boolean isDigit(final char c) {
        return (c >= '0' && c <= '9');
    }
}
