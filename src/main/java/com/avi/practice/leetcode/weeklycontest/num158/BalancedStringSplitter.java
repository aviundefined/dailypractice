package com.avi.practice.leetcode.weeklycontest.num158;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BalancedStringSplitter {

    public int balancedStringSplit(final String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        final char[] chars = s.toUpperCase().toCharArray();
        int sIdx = 0, eIdx = 0;
        int numR = 0;
        int numL = 0;
        int numberOfBalancedStrings = 0;
        while (sIdx <= eIdx && eIdx < s.length()) {
            final char curr = chars[eIdx];
            switch (curr) {
                case 'R':
                    numR++;
                    break;
                case 'L':
                    numL++;
                    break;
                default:
                    break;
            }
            eIdx++;
            if (numL == numR) {
                numberOfBalancedStrings++;
                sIdx = eIdx;
                eIdx = sIdx;
                numR = 0;
                numL = 0;
            }
        }
        return numberOfBalancedStrings;
    }
}
