package com.avi.practice.geeksforgeeks.questions;

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
        return count;
        // Total: n * n * log(n)
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
