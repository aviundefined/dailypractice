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

    final int findRecursive(final int x) {
        return _findRecursive(0, n - 1, x);
    }

    final int findIterative(final int x) {
        return _findIterative(0, n - 1, x);
    }

    final int findFirstRecursive(final int x) {
        int idx = _findRecursive(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int minIdx = idx;
        // x found at idx , not try to find smaller idx
        while (idx != NOT_FOUND) {
            idx = _findRecursive(0, idx - 1, x);
            if (idx != NOT_FOUND) {
                minIdx = idx;
            }
        }
        return minIdx;
    }

    final int findLastRecursive(final int x) {
        int idx = _findRecursive(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int maxIdx = idx;
        // x found at idx , not try to find largest idx
        while (idx != NOT_FOUND) {
            idx = _findRecursive(idx + 1, n - 1, x);
            if (idx != NOT_FOUND) {
                maxIdx = idx;
            }
        }
        return maxIdx;
    }

    final int findFirstIterative(final int x) {
        int idx = _findIterative(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int minIdx = idx;
        // x found at idx , not try to find smaller idx
        while (idx != NOT_FOUND) {
            idx = _findIterative(0, idx - 1, x);
            if (idx != NOT_FOUND) {
                minIdx = idx;
            }
        }
        return minIdx;
    }

    final int findLastIterative(final int x) {
        int idx = _findIterative(0, n - 1, x);
        // if not found then simply return it
        if (idx == NOT_FOUND) {
            return idx;
        }
        int maxIdx = idx;
        // x found at idx , not try to find largest idx
        while (idx != NOT_FOUND) {
            idx = _findIterative(idx + 1, n - 1, x);
            if (idx != NOT_FOUND) {
                maxIdx = idx;
            }
        }
        return maxIdx;
    }

    private int _findRecursive(final int left, final int right, final int x) {
        if (right < left) {
            return NOT_FOUND;
        }
        final int mid = (left + right) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] > x) {
            return _findRecursive(left, mid - 1, x);
        }
        if (arr[mid] < x) {
            return _findRecursive(mid + 1, right, x);
        }
        return NOT_FOUND;
    }

    private int _findIterative(int left, int right, final int x) {
        if (right < left) {
            return NOT_FOUND;
        }
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                right = mid - 1;
            }
            if (arr[mid] < x) {
                left = mid + 1;
            }
        }
        return NOT_FOUND;
    }
}
