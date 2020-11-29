package com.avi.practice.company.microsoft.interviewbit;

/**
 * Created by navinash on 29/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TrailingZerosInFactorial {

    public final int count(int A) {
        if (A <= 4) {
            return 0;
        }

        int pow = 1;
        int trailingZeros = 0;
        while (true) {
            final int curr = (int) (A / Math.pow(5, pow));
            if (curr == 0) {
                break;
            }
            trailingZeros += curr;
            pow++;
        }
        return trailingZeros;
    }
}
