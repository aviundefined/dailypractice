package com.avi.practice.company.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by navinash on 12/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountDistinctElementsInEveryWindowSizeK {

    public final List<Integer> solve(final int[] a, final int k) {
        if (a == null || a.length < k) {
            return Collections.emptyList();
        }

        final List<Integer> result = new ArrayList<>();
        int l = 0;
        int r = 0;
        final Map<Integer, Integer> counts = new HashMap<>();
        final int n = a.length;
        while (l <= r && r < n) {
            counts.compute(a[r], (key, value) -> {
                if (value == null) {
                    return 1;
                }
                return ++value;
            });
            if (r - l + 1 == k) {
                result.add(counts.size());
                final int leftCount = counts.get(a[l]);
                if (leftCount <= 1) {
                    counts.remove(a[l]);
                } else {
                    counts.put(a[l], leftCount - 1);
                }
                l++;
            }
            r++;
        }
        return result;
    }
}
