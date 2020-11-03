package com.avi.practice.leetcode.weeklycontest.num213;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 03/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class FurthestBuildingYouCanReachTest {

    @Test
    public void furthestBuilding() {
        final FurthestBuildingYouCanReach solver = new FurthestBuildingYouCanReach();
        {
            final int[] heights = {4,2,7,6,9,14,12};
            final int bricks = 5;
            final int ladders = 1;
            final int expected = 4;
            final int actual = solver.furthestBuilding(heights, bricks, ladders);
            Assert.assertEquals(expected, actual);
        }

        {
            final int[] heights = {4,12,2,7,3,18,20,3,19};
            final int bricks = 10;
            final int ladders = 2;
            final int expected = 7;
            final int actual = solver.furthestBuilding(heights, bricks, ladders);
            Assert.assertEquals(expected, actual);
        }

        {
            final int[] heights = {14,3,19,3};
            final int bricks = 17;
            final int ladders = 0;
            final int expected = 3;
            final int actual = solver.furthestBuilding(heights, bricks, ladders);
            Assert.assertEquals(expected, actual);
        }

        {
            final int[] heights = {3, 19};
            final int bricks = 87;
            final int ladders = 1;
            final int expected = 1;
            final int actual = solver.furthestBuilding(heights, bricks, ladders);
            Assert.assertEquals(expected, actual);
        }


        {
            final int[] heights = {1, 2};
            final int bricks = 0;
            final int ladders = 0;
            final int expected = 0;
            final int actual = solver.furthestBuilding(heights, bricks, ladders);
            Assert.assertEquals(expected, actual);
        }
    }
}