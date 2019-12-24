package com.avi.practice.geeksforgeeks.questions.arrays;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 24/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class DutchFlagSort {

    public final void sort_0_1(final int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int zero = 0;
        int one = a.length - 1;
        while (zero < one) {
            if (a[zero] == 1) {
                CommonUtils.swap(a, zero, one);
                one--;
            } else {
                zero++;
            }
        }
    }

    public final void sort_0_1_2(final int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        final int n = a.length;
        int zero = 0;
        int one = 0;
        int two = n - 1;
        while (one <= two) {
            if (a[one] == 0) {
                CommonUtils.swap(a, zero, one);
                zero++;
                one++;
            } else if (a[one] == 1) {
                one++;
            } else {
                CommonUtils.swap(a, one, two);
                two--;
            }
        }
    }
}
