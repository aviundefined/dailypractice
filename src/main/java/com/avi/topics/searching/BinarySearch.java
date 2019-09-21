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

    final int find(final int x) {
        return _find(0, n - 1, x);
    }

    final int findFirst(final int x) {
        int idx = _find(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int minIdx = idx;
        // x found at idx , not try to find smaller idx
        while (idx != NOT_FOUND) {
            idx = _find(0, idx - 1, x);
            if (idx != NOT_FOUND) {
                minIdx = idx;
            }
        }
        return minIdx;
    }

    final int findLast(final int x) {
        int idx = _find(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int maxIdx = idx;
        // x found at idx , not try to find largest idx
        while (idx != NOT_FOUND) {
            idx = _find(idx + 1, n - 1, x);
            if (idx != NOT_FOUND) {
                maxIdx = idx;
            }
        }
        return maxIdx;
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
