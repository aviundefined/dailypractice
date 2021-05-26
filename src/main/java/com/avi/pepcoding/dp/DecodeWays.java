package com.avi.pepcoding.dp;

/**
 * Created by navinash on 26/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DecodeWays {

    public int decodeWays(final String s) {
        if (s.length() <= 1) {
            return 1;
        }
        final int n = s.length();
        final int[] f = new int[n];

        f[0] = 1;

        for (int i = 1; i < n; i++) {
            final char curr = s.charAt(i);
            final char last = s.charAt(i - 1);
            if (curr == '0' && last == '0') {
                f[i] = 0; // cant' do anything
            } else if (curr == '0' && last != '0') {
                // curr character can be used but with last character it can be used if last <= 2
                if (last == '1' || last == '2') {
                    f[i] = (i >= 2 ? f[i - 2] : 0);
                } else {
                    f[i] = 0;
                }
            } else if (curr != '0' && last == '0') {
                f[i] = f[i - 1];
            } else {
                final int num = Integer.parseInt(last + "" + curr);
                if (num <= 26) {
                    f[i] = f[i - 1] + (i >= 2 ? f[i - 2] : 1);
                } else {
                    f[i] = f[i - 1];
                }
            }
        }

        return f[n - 1];
    }
}
