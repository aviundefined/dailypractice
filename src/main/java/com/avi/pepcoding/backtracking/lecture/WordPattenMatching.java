package com.avi.pepcoding.backtracking.lecture;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 04/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class WordPattenMatching {

    public void allPossibilities(final String s, final String pattern) {

        final Map<Character, String> map = new HashMap<>();
        backtrack(0, pattern, s, map);
    }

    private void backtrack(int i, String pattern, String s, Map<Character, String> map) {
        if (i >= pattern.length() && s.equals("")) {
            System.out.println(map);
            return;
        }
        if (i >= pattern.length() && !s.equals("")) {
            return;
        }
        final char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            final String previousMapping = map.get(c);
            if (previousMapping.length() <= s.length()) {
                final String left = s.substring(0, previousMapping.length());
                if (left.equals(previousMapping)) {
                    final String right = s.substring(previousMapping.length());
                    backtrack(i + 1, pattern, right, map);
                }
            }
        } else {
            for (int j = 0; j < s.length(); j++) {
                final String left = s.substring(0, j + 1);
                final String right = s.substring(j + 1);
                map.put(c, left);
                backtrack(i + 1, pattern, right, map);
                map.remove(c);
            }
        }

    }
}
