package com.avi.practice.leetcode.biweekly;

/**
 * Created by navinash on 20/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }

        final char[] chars = s.toLowerCase().toCharArray();
        // 1 base indexing
        final int n = chars.length;
        final int[] countOfBsOnLeftByIndex = new int[n + 1];
        countOfBsOnLeftByIndex[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (chars[i - 1] == 'b') {
                countOfBsOnLeftByIndex[i] = countOfBsOnLeftByIndex[i - 1] + 1;
            } else {
                countOfBsOnLeftByIndex[i] = countOfBsOnLeftByIndex[i - 1];
            }
        }

        final int[] countOfAsOnRightByIndex = new int[n + 1];
        countOfAsOnRightByIndex[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (chars[n - i] == 'a') {
                countOfAsOnRightByIndex[i] = countOfAsOnRightByIndex[i - 1] + 1;
            } else {
                countOfAsOnRightByIndex[i] = countOfAsOnRightByIndex[i - 1];
            }
        }
        int min = n;
        for (int i = 0; i <= n; i++) {
            final int curr = countOfBsOnLeftByIndex[i] + countOfAsOnRightByIndex[n - i];
            if (curr < min) {
                min = curr;
            }
        }

        return min;
    }


}
