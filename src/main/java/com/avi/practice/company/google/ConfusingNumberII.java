package com.avi.practice.company.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by navinash on 22/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConfusingNumberII {

    private static final Map<Integer, Integer> map = new HashMap<>();
    private static final int[] possibles = {0, 1, 6, 8, 9};

    // {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, -1);
        map.put(3, -1);
        map.put(4, -1);
        map.put(5, -1);
        map.put(6, 9);
        map.put(7, -1);
        map.put(8, 8);
        map.put(9, 6);
    }

    int count = 0;

    public int confusingNumberII(int n) {

        if (n <= 5) {
            return 0;
        }

        if (n <= 8) {
            return 1; //  6
        }

        if (n <= 9) {
            return 2; // 6,9
        }
        backtrack(0L, n);
        return count;
    }


    private void backtrack(final long curr, final int n) {
        if (isConfusingNumber(curr)) {
            count++;
        }
        for (final int possible : possibles) {
            if (curr * 10 + possible <= n && curr * 10 + possible != 0) {
                backtrack(curr * 10 + possible, n);
            }
        }
    }

    private boolean isConfusingNumber(long n) {
        final long num = n;
        long rotatedNum = 0L;
        while (n > 0) {
            final int rem = (int) (n % 10);
            if (map.get(rem) < 0) {
                return false;
            }
            rotatedNum = rotatedNum * 10 + map.get(rem);
            n = n / 10;
        }
        return rotatedNum != num;
    }
}
