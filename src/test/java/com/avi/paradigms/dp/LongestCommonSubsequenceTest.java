package com.avi.paradigms.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 28/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class LongestCommonSubsequenceTest {

    @Test
    public void lcss() {
        final LongestCommonSubsequence solver = new LongestCommonSubsequence();
        {
            final String s1 = "aab";
            final String s2 = "abz";
            final int expected = 2;
            final int lcss = solver.lcss(s1, s2);
            Assert.assertEquals(String.format("[%s], [%s]", s1, s2), expected, lcss);
        }
        {
            final String s1 = "AAGTAB";
            final String s2 = "GXTXAYB";
            final int expected = 4;
            final int lcss = solver.lcss(s1, s2);
            Assert.assertEquals(String.format("[%s], [%s]", s1, s2), expected, lcss);
        }
        {
            final String s1 = "AGGTAB";
            final String s2 = "GXTXAYB";
            final int expected = 4;
            final int lcss = solver.lcss(s1, s2);
            Assert.assertEquals(String.format("[%s], [%s]", s1, s2), expected, lcss);
        }
        {
            final String s1 = "ABCDGH";
            final String s2 = "AEDFHR";
            final int expected = 2;
            final int lcss = solver.lcss(s1, s2);
            Assert.assertEquals(String.format("[%s], [%s]", s1, s2), expected, lcss);
        }
    }
}
