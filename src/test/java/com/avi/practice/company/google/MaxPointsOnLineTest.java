package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaxPointsOnLineTest {
    private static final MaxPointsOnLine solver = new MaxPointsOnLine();

    @Test
    public void maxPoints1() {
        final int[][] points = {
                {1, 1},
                {2, 2},
                {3, 3}
        };
        final int expected = 3;
        for (final int[] point : points) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }
        System.out.println("------------");
        final int actual = solver.maxPoints(points);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxPoints2() {
        final int[][] points = {
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}
        };
        final int expected = 4;
        for (final int[] point : points) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }
        System.out.println("------------");
        final int actual = solver.maxPoints(points);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxPoints3() {
        final int[][] points = {
                {4, 5},
                {4, -1},
                {4, 0}
        };
        final int expected = 3;
        for (final int[] point : points) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }
        System.out.println("------------");
        final int actual = solver.maxPoints(points);
        Assert.assertEquals(expected, actual);
    }
}