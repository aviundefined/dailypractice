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
}
