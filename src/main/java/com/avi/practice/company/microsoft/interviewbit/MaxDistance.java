package com.avi.practice.company.microsoft.interviewbit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxDistance {

    public int maximumGap(final List<Integer> A) {
        if (A == null || A.size() == 0) {
            return -1;
        }
        final ValueIndex[] valueIndices = new ValueIndex[A.size()];
        for (int i = 0; i < A.size(); i++) {
            valueIndices[i] = new ValueIndex(A.get(i), i);
        }
        Arrays.sort(valueIndices, Comparator.comparingInt(o -> o.value));
        // question is reduced to find  max difference in this arr
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (ValueIndex valueIndex : valueIndices) {
            min = Math.min(valueIndex.index, min);
            max = Math.max(max, valueIndex.index - min);
        }
        return max;
    }

    private static final class ValueIndex {
        private final int value;
        private final int index;

        private ValueIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
