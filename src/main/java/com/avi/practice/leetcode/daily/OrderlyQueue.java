package com.avi.practice.leetcode.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 06/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OrderlyQueue {

    private String min = null;

    public String orderlyQueue(String s, int k) {
        if (s == null || s.length() == 0 || "".equals(s.trim())) {
            return s;
        }
        if (k == 0) {
            return s;
        }

        final Map<String, String> dp = new HashMap<>();
        dfs(s, k, dp, new HashSet<>());
        return min;
    }

    private String dfs(final String s, final int k, final Map<String, String> dp, Set<String> visited) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        if(visited.contains(s)) {
            return s;
        }

        visited.add(s);
        String currMin = s;
        for (int i = 0; i < k && i < s.length(); i++) {
            final String newString = newString(s, i);

            final String curr = dfs(newString, k, dp, visited);
            // if curr is smaller then update
            if (curr.compareTo(currMin) < 0) {
                currMin = curr;
            }
        }

        dp.put(s, currMin);
        if (min == null || currMin.compareTo(min) < 0) {
            min = currMin;
        }
        return currMin;
    }

    private String newString(final String s, final int idx1) {
        // System.out.printf("s: %s, idx1: %s, idx2: %s\n", s, idx1, idx2);
        final char c1 = s.charAt(idx1);
        final StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(idx1);
        sb.append(c1);
        return sb.toString();
    }
}
