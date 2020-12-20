package com.avi.practice.leetcode.weeklycontest.num219;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StoneGameVIITest {

    private static final StoneGameVII solver = new StoneGameVII();
    @Test
    public void stoneGameVII_1() {
        final int[] stones = {5,3,1,4,2};
        final int expected = 6;
        final int actual = solver.stoneGameVII(stones);
        Assert.assertEquals(Arrays.toString(stones), expected, actual);
    }
}