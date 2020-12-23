package com.avi.practice.company.atlassian;

/**
 * Created by navinash on 22/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumDigitsUntilOne {

    public int solve(int n) {
        if (n < 10) {
            return n;
        }

        while (n > 10) {
            final String s = String.valueOf(n);
            n = 0;
            for (int i = 0; i < s.length(); i++) {
                n += Character.getNumericValue(s.charAt(i));
            }
        }
        return n;
    }
}
