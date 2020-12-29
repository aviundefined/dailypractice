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
public class WhereWillTheBallFallTest {
    private static final WhereWillTheBallFall solver = new WhereWillTheBallFall();

    @Test
    public void findBall1() {
        final int[][] grid = {
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        };
        final int[] expected = {1, -1, -1, -1, -1};
        for (final int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        final int[] actual = solver.findBall(grid);
        Assert.assertArrayEquals(expected, actual);
    }
}