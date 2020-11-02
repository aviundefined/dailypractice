package com.avi.practice.leetcode.weeklycontest.num212;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 02/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class PathWithMinimumEffortTest {

    private final PathWithMinimumEffort solver = new PathWithMinimumEffort();

    @Test
    public void minimumEffortPath() {
        {
            final int[][] heights = {
                    {1, 2, 2},
                    {3, 8, 2},
                    {5, 3, 5}
            };

            final int expected = 2;
            final int actual = solver.minimumEffortPath(heights);
            Assert.assertEquals(expected, actual);
        }
    }
}