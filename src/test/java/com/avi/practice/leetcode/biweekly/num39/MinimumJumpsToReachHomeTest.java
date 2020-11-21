package com.avi.practice.leetcode.biweekly.num39;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 21/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumJumpsToReachHomeTest {

    private static final MinimumJumpsToReachHome solver = new MinimumJumpsToReachHome();

    @Test
    public void minimumJumps() {
        {
            final int[] forbidden = {14, 4, 18, 1, 15};
            final int a = 3;
            final int b = 15;
            final int x = 9;
            final int expected = 3;
            final String s = String.format("Forbidden: %s, forward jump: %d, backward jump: %d, target: %d", Arrays.toString(forbidden), a, b, x);
            final int actual = solver.minimumJumps(forbidden, a, b, x);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final int[] forbidden = {8, 3, 16, 6, 12, 20};
            final int a = 15;
            final int b = 13;
            final int x = 11;
            final int expected = -1;
            final String s = String.format("Forbidden: %s, forward jump: %d, backward jump: %d, target: %d", Arrays.toString(forbidden), a, b, x);
            final int actual = solver.minimumJumps(forbidden, a, b, x);
            Assert.assertEquals(s, expected, actual);
        }
        {
            final int[] forbidden = {1, 6, 2, 14, 5, 17, 4};
            final int a = 16;
            final int b = 9;
            final int x = 7;
            final int expected = 2;
            final String s = String.format("Forbidden: %s, forward jump: %d, backward jump: %d, target: %d", Arrays.toString(forbidden), a, b, x);
            final int actual = solver.minimumJumps(forbidden, a, b, x);
            Assert.assertEquals(s, expected, actual);
        }
    }
}