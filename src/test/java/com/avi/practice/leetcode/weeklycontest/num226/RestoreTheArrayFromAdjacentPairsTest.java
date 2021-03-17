package com.avi.practice.leetcode.weeklycontest.num226;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 06/02/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RestoreTheArrayFromAdjacentPairsTest {

    private final RestoreTheArrayFromAdjacentPairs solver =new RestoreTheArrayFromAdjacentPairs();
    @Test
    public void restoreArray() {
        final int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        final int[] expected = {1, 2, 3, 4};
        final int[] actual = solver.restoreArray(adjacentPairs);
        Assert.assertArrayEquals(expected, actual);
    }
}