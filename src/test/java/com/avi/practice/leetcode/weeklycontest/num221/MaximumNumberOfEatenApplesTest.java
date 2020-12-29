package com.avi.practice.leetcode.weeklycontest.num221;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 28/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumNumberOfEatenApplesTest {

    private static final MaximumNumberOfEatenApples solver = new MaximumNumberOfEatenApples();

    @Test
    public void eatenApples() {
        final int[] apples = {1, 2, 3, 5, 2};
        final int[] days = {3, 2, 1, 4, 2};
        final int expected = 7;
        final int actual = solver.eatenApples(apples, days);
        Assert.assertEquals(String.format("apples: %s, days: %s", Arrays.toString(apples), Arrays.toString(days)), expected, actual);
    }
}