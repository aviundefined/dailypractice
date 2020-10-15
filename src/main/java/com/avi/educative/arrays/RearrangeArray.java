package com.avi.educative.arrays;

/**
 * Created by navinash on 15/10/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class RearrangeArray {

    final void maxMinAlternativeSortedArray(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int maxIdx = arr.length - 1;
        int minIdx = 0;
        final int max = arr[maxIdx] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxIdx] % max) * max;
                maxIdx--;
            } else {
                arr[i] = arr[i] + (arr[minIdx] % max) * max;
                minIdx++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max;
        }
    }
}
