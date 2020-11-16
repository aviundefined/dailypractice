package com.avi.practice.company.salesforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 17/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumZeroSubset {

    public Set<SubArray> zeroSumSubArray(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return Collections.emptySet();
        }

        final Set<SubArray> result = new HashSet<>();
        final Map<Integer, List<Integer>> sums = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sums.containsKey(sum)) {
                final List<Integer> idxs = sums.get(sum);
                for (int idx : idxs) {
                    result.add(new SubArray(idx + 1, i));
                }
            }
            if (sum == 0) {
                result.add(new SubArray(0, i));
            }
            sums.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    static final class SubArray {

        private final int start;
        private final int end;

        SubArray(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "SubArray{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SubArray subArray = (SubArray) o;
            return start == subArray.start &&
                    end == subArray.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
