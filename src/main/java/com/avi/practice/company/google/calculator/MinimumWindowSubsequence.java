package com.avi.practice.company.google.calculator;

/**
 * Created by navinash on 13/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumWindowSubsequence {

    public String minWindow(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }

        final int sourceLen = s1.length();
        final int targetLen = s2.length();
        // source is empty or target is empty or target is bigger than souce
        if (sourceLen == 0 || targetLen == 0 || targetLen > sourceLen) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        int fast = 0;

        while (fast < sourceLen) {
            int target = 0;
            while (fast < sourceLen) {
                if (s1.charAt(fast) == s2.charAt(target)) {
                    target++;
                }
                if (target == targetLen) {
                    break;
                }
                fast++;
            }

            if (fast == sourceLen) {
                break;
            }

            // pattern found, now minimize it using slow pointer
            target = targetLen - 1;
            int slow = fast;
            while (slow >= 0) {
                if (s1.charAt(slow) == s2.charAt(target)) {
                    target--;
                }
                if (target < 0) {
                    break;
                }
                slow--;
            }

            if (min > fast - slow + 1) {
                min = fast - slow + 1;
                start = slow;
                end = fast;
            }
            fast = slow + 1;
        }


        if (start == -1) {
            return "";
        }
        return s1.substring(start, end + 1);
    }

}
