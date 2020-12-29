package com.avi.practice.company.microsoft.leetcode.medium;

/**
 * Created by navinash on 25/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        final boolean isDivisorPositive = divisor > 0;
        final boolean isDividendPositive = dividend > 0;

        long divisorL = divisor;
        long dividendL = dividend;
        if (!isDivisorPositive) {
            divisorL = -((long) divisor);
        }
        if (!isDividendPositive) {
            dividendL = -((long) dividend);
        }

        int multi = 0;
        while (dividendL >= divisorL) {
            dividendL -= divisorL;
            multi++;
        }

        if ((isDividendPositive && isDivisorPositive)
                || (!isDividendPositive && !isDivisorPositive)) {
            return multi;
        }
        return -multi;
    }
}
