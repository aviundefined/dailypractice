package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class LinearSearch {

    private static final int NOT_FOUND = -1;
    private final int[] arr;
    private final int n;

    LinearSearch(int[] arr) {
        if (CommonUtils.isEmpty(arr)) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        this.arr = arr;
        this.n = arr.length;
    }

    final int findFirstIndex(final int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    final int findLastIndex(final int x) {
        int lastIdx = NOT_FOUND;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                lastIdx = i;
            }
        }
        return lastIdx;
    }

    /**
     * Returns value less or equal to x
     */
    final int floor(final int x) {
        int floor = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a <= x) {
                floor = Math.max(floor, a);
            }
        }
        if (floor == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return floor;
    }

    /**
     * Returns value greater or equal to x
     */
    final int ceiling(final int x) {
        int ceiling = Integer.MAX_VALUE;
        for (int a : arr) {
            if (a >= x) {
                ceiling = Math.min(ceiling, a);
            }
        }
        if (ceiling == Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }
        return ceiling;
    }

}
