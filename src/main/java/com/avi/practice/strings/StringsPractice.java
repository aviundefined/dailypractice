package com.avi.practice.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by navinash on 11/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class StringsPractice {

    /**
     * Time:  O(length of string)
     * Space: O(length of string)
     */
    static String maximumLengthSubstringWithNoDuplicates(final String str) {
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return str;
        }

        final int n = str.length();
        final char[] chars = str.toCharArray();
        int s = 0, e = 1, max = -1, sIdx = 0, eIdx = 0;
        final Map<Character, Integer> counts = new LinkedHashMap<>();
        counts.put(chars[s], 1);
        while (s <= e && e < n) {
            if (!counts.containsKey(chars[e])) {
                counts.put(chars[e], 1);
                if (e - s >= max) {
                    max = e - s;
                    sIdx = s;
                    eIdx = e;
                }
                e++;
                continue;
            }

            final int v = counts.get(chars[e]);
            counts.put(chars[e], v + 1);
            while (s <= e && counts.get(chars[e]) > 1) {
                if (counts.get(chars[e]) == 1) {
                    break;
                }
                final int curr = counts.get(chars[s]);
                if (curr == 1) {
                    counts.remove(chars[s]);
                } else {
                    counts.put(chars[s], curr - 1);
                }
                s++;
            }
            e++;
        }

        final char[] subStr = new char[eIdx - sIdx + 1];
        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = chars[sIdx + i];
        }
        return String.valueOf(subStr);
    }
}
