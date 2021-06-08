package com.avi.practice.leetcode.problems.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 30/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximizeScoreAfterNOperations {

    final int gcd(final int a, final int b) {
        final Map<String, Integer> dp = new HashMap<>();
        return _gcd(a, b, dp);
    }

    private int _gcd(final int a, final int b, Map<String, Integer> dp) {
        final String key = Math.min(a, b) + "-" + Math.max(a, b);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (a == 0) {
            dp.put(key, b);

        } else if (b == 0) {
            dp.put(key, a);

        } else if (a == b) {
            dp.put(key, a);

        } else if (a > b) {
            final int gcd = _gcd(a - b, b, dp);
            dp.put(key, gcd);
        } else {
            final int gcd = _gcd(a, b - a, dp);
            dp.put(key, gcd);
        }
        return dp.get(key);
    }
}
