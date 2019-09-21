package com.avi.topics.searching;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 21/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class BinarySearch {

    private static final int NOT_FOUND = -1;
    private final int[] arr;
    private final int n;

    BinarySearch(final int[] arr) {
        if (CommonUtils.isEmpty(arr)) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        this.arr = arr;
        this.n = arr.length;
    }

    int find(final int x) {
        return _find(0, n - 1, x);
    }

    private int _find(final int left, final int right, final int x) {
        if (right < left) {
            return NOT_FOUND;
        }
        final int mid = (left + right) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] > x) {
            return _find(left, mid - 1, x);
        }
        if (arr[mid] < x) {
            return _find(mid + 1, right, x);
        }
        return NOT_FOUND;
    }
}
