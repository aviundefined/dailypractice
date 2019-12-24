package com.avi.practice.geeksforgeeks.questions.arrays;

import java.util.Arrays;

/**
 * Created by navinash on 22/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class TripletsCounter {

    public final int count(final int[] a) {
        if (a == null || a.length < 3) {
            return -1;
        }

        // Sort the array: n* log(n)
        Arrays.sort(a);
        int count = 0;
        final int n = a.length;
        for (int i = 0; i < n; i++) { // n
            final int e1 = a[i];
            for (int j = i + 1; j < n - 1; j++) { // n
                final int e2 = a[j];
                final int sum = e1 + e2;
                // log n
                final int idx = binarySearch(a, j + 1, sum);
                if (idx != -1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return -1;
        }
        return count;
        // Total: n * n * log(n)
    }

    public final int countOptimized(final int[] a) {
        // assumptions:
        // 1) unique elements
        if (a == null || a.length < 3) {
            return -1;
        }
        // Sort the array: n* log(n)
        Arrays.sort(a);
        int count = 0;
        final int n = a.length;
        for (int i = n - 1; i >= 0; i--) { // n
            int s = 0;
            int e = i - 1;
            while (s <= e && e > 0 && s <= i - 1) { // n
                final int sum = a[s] + a[e];
                if (a[i] == sum) {
                    count++;
                    s++;
                    e--;
                } else if (sum > a[i]) {
                    e--;
                } else if (sum < a[i]) {
                    s++;
                }
            }
        }
        if (count == 0) {
            return -1;
        }
        return count;
    }


    private int binarySearch(final int[] a, int start, final int key) {

        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                start = mid + 1;
            } else if (a[mid] > key) {
                end = mid - 1;
            }
        }
        return -1;
    }


}
