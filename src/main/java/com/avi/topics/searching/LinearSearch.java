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

    final int peakLinearSearch() {
        if (n == 1) {
            return arr[0];
        }
        if (arr[0] >= arr[1]) {
            return arr[0];
        }
        for (int i = 1; i <= n - 2; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                return arr[i];
            }
        }
        if (arr[n - 1] >= arr[n - 2]) {
            return arr[n - 1];
        }
        return Integer.MIN_VALUE;
    }

    final int peakBinarySearch() {
        if (n == 1) {
            return arr[0];
        }
        if (arr[0] >= arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] >= arr[n - 2]) {
            return arr[n - 1];
        }
        final int peakIndex = _peakBinarySearchIndex();
        if (peakIndex == NOT_FOUND) {
            return Integer.MIN_VALUE;
        }
        return arr[peakIndex];
    }

    private Integer _peakBinarySearchIndex() {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
                return mid;
            }
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
        }
        return NOT_FOUND;
    }
}
