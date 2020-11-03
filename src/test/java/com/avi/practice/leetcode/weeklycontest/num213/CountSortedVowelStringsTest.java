package com.avi.practice.leetcode.weeklycontest.num213;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountSortedVowelStringsTest {

    @Test
    public void countVowelStrings() {
        final CountSortedVowelStrings solver = new CountSortedVowelStrings();
        {
            final int n  = 2;
            final int actual = 15;
            final int expected = solver.countVowelStrings(n);
            Assert.assertEquals(actual, expected);
        }

        {
            final int n  = 3;
            final int actual = 35;
            final int expected = solver.countVowelStrings(n);
            Assert.assertEquals(actual, expected);
        }

        {
            final int n =  33;
            final int actual = 66045;
            final int expected = solver.countVowelStrings(n);
            Assert.assertEquals(actual, expected);
        }
    }
}