package com.avi.practice.leetcode.weeklycontest.num216;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 24/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumInitialEnergyToFinishTasksTest {

    private static final MinimumInitialEnergyToFinishTasks solver = new MinimumInitialEnergyToFinishTasks();

    @Test
    public void minimumEffort1() {
        final int[][] tasks = {{1, 2}, {2, 4}, {4, 8}};
        final int expected = 8;
        CommonUtils.printMatrix(tasks);
        final int actual = solver.minimumEffort(tasks);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minimumEffort2() {
        final int[][] tasks = {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}};
        final int expected = 32;
        CommonUtils.printMatrix(tasks);
        final int actual = solver.minimumEffort(tasks);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minimumEffort3() {
        final int[][] tasks = {{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}};
        final int expected = 27;
        CommonUtils.printMatrix(tasks);
        final int actual = solver.minimumEffort(tasks);
        Assert.assertEquals(expected, actual);
    }
}