package com.avi.practice.leetcode.weeklycontest.num219;

import com.avi.practice.utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 19/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumHeightByStackingCuboidsTest {
    private static final MaximumHeightByStackingCuboids solver = new MaximumHeightByStackingCuboids();

    @Test
    public void maxHeight1() {
        final int[][] cuboids = {
                {50, 45, 20},
                {95, 37, 53},
                {45, 23, 12}
        };

        CommonUtils.printMatrix(cuboids);
        final int expected = 190;
        final int actual = solver.maxHeight(cuboids);
        Assert.assertEquals(expected, actual);
        System.out.println("---------------------------");
    }

    @Test
    public void maxHeight2() {
        final int[][] cuboids = {
                {38, 25, 45},
                {76, 35, 3}
        };

        CommonUtils.printMatrix(cuboids);
        final int expected = 76;
        final int actual = solver.maxHeight(cuboids);
        Assert.assertEquals(expected, actual);
        System.out.println("---------------------------");
    }

    @Test
    public void maxHeight3() {
        final int[][] cuboids = {
                {7, 11, 17},
                {7, 17, 11},
                {11, 7, 17},
                {11, 17, 7},
                {17, 7, 11},
                {17, 11, 7}
        };

        CommonUtils.printMatrix(cuboids);
        final int expected = 102;
        final int actual = solver.maxHeight(cuboids);
        Assert.assertEquals(expected, actual);
        System.out.println("---------------------------");
    }
}