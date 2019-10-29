package com.avi.practice.leetcode.weeklycontest.num157;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by navinash on 23/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestArithmeticSubsequenceGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null) {
            return 0;
        }
        final int n = arr.length;
        if (n <= 1) {
            return n; // n = 0 then 0, n = 1 then 1
        }
        final Map<Integer, LinkedList<Integer>> elementByIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final LinkedList<Integer> indexes = elementByIndex.computeIfAbsent(arr[i], key -> new LinkedList<>());
            indexes.add(i);
        }
        final Set<Integer> visitedIndexes = new HashSet<>();
        int max = 0;
        int curMax = 0;
        for (int i = 0; i < n; i++) {
            if (visitedIndexes.size() == n) {
                break;
            }
            if (visitedIndexes.contains(i)) {
                continue;
            }
            int element = arr[i];
            int idx = i;
            while (idx < n && elementByIndex.containsKey(element) && !visitedIndexes.contains(idx)) {
                curMax++;
                visitedIndexes.add(idx); // mark as visited
                element = element + difference; // next element
                final int lastIdx = idx;
                final LinkedList<Integer> indexes = elementByIndex.get(element);
                idx = -1;
                if (indexes != null && indexes.size() != 0) {
                    for (final int index : indexes) {
                        if (!visitedIndexes.contains(index) && index > lastIdx) {
                            idx = index;
                            break;
                        }
                    }
                }
                if (idx == -1) {
                    break;
                }
            }
            max = Math.max(max, curMax);
            curMax = 0;
        }
        return max;
    }
}
