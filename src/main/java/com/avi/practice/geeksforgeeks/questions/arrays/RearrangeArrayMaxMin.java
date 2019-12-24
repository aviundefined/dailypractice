package com.avi.practice.geeksforgeeks.questions.arrays;

/**
 * Created by navinash on 24/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RearrangeArrayMaxMin {

    public void arrangeInPlace(final int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        final int n = a.length;
        final int divisor = a[n - 1] + 1;
        int maxIndex = n - 1;
        int minIndex = 0;
        for (int i = 0; i <= n - 1; i++) {
            if (i % 2 == 0) {
                a[i] = a[i] + a[maxIndex] % divisor * divisor;
                maxIndex--;
            } else {
                a[i] = a[i] + a[minIndex] % divisor * divisor;
                minIndex++;
            }
        }

        for (int i = 0; i <= n - 1; i++) {
            a[i] = a[i] / divisor;
        }
    }
}
