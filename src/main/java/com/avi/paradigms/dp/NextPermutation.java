package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 11/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class NextPermutation {

    final String next(final String s) {
        if (CommonUtils.isEmpty(s)) {
            return s;
        }

        final char[] chars = s.toCharArray();
        final int n = chars.length;
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] > chars[i - 1]) {
                start = i;
            }
        }
        // Corner case, whole string is reversed
        if (start == 0) {
            return "";
        }
        int minIdx = -1, min = Integer.MAX_VALUE;
        for (int i = start; i < n; i++) {
            if (chars[i] > chars[start - 1] && chars[i] < min) {
                min = chars[i];
                minIdx = i;
            }
        }
        CommonUtils.swap(chars, start - 1, minIdx);
        int l = start, r = n - 1;
        while (l < r) {
            CommonUtils.swap(chars, l, r);
            l++;
            r--;
        }
        return String.valueOf(chars);
    }
}
