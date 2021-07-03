package com.avi.practice.company.google;

/**
 * Created by navinash on 03/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {

        int count = 0;
        for (final String word : words) {
            if (canExpress(word, s)) {
                count++;
            }
        }
        return count;
    }

    private boolean canExpress(String word, String s) {
        if (word == null) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) != s.charAt(j)) {
                return false;
            }
            // char matches -> get the length of the repeated segment
            final int l1 = repeatedSegmentLength(word, i);
            final int l2 = repeatedSegmentLength(s, j);
            if ((l1 != l2 && l2 < 3) || (l2 >= 3 && l2 < l1)) {
                return false;
            }
            i += l1;
            j += l2;
        }

        return i == word.length() && j == s.length();
    }

    private int repeatedSegmentLength(String s, int index) {
        int length = 1;
        for (int i = index; i < s.length() - 1; i++) {
            if (s.charAt(index) == s.charAt(i + 1)) {
                length++;
                continue;
            }
            break;
        }
        return length;
    }
}
