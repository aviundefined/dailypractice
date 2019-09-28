package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

/**
 * Created by navinash on 28/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class LongestCommonSubsequence {

    /**
     * Time:  O(s1.length() * s2.length()
     * Space: O(s1.length() * s2.length()
     */
    final int lcss(final String s1, final String s2) {
        if (CommonUtils.isEmpty(s1) || CommonUtils.isEmpty(s2)) {
            return 0;
        }

        final char[] chars1 = s1.toLowerCase().toCharArray();
        final char[] chars2 = s2.toLowerCase().toCharArray();

        final int[][] lcss = new int[chars1.length][chars2.length];

        // fill first column
        for (int i = 0; i < chars1.length; i++) {
            lcss[i][0] = chars1[i] == chars2[0] ? 1 : 0;
        }
        // fill first row
        for (int j = 0; j < chars2.length; j++) {
            lcss[0][j] = chars1[0] == chars2[j] ? 1 : 0;
        }
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    lcss[i][j] = 1 + lcss[i - 1][j - 1];
                } else {
                    lcss[i][j] = Math.max(lcss[i - 1][j], lcss[i][j - 1]);
                }
            }
        }
        return lcss[chars1.length - 1][chars2.length - 1];
    }
}
