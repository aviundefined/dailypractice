package com.avi.practice.leetcode.weeklycontest.num159;


import com.avi.practice.leetcode.weeklycontest.num159.StraightLineChecker.Coordinate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class StraightLineCheckerTest {

    @Test
    public void isOnLine_True() {
        final List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(1, 2));
        coordinates.add(new Coordinate(2, 3));
        coordinates.add(new Coordinate(3, 4));
        coordinates.add(new Coordinate(4, 5));
        coordinates.add(new Coordinate(5, 6));
        coordinates.add(new Coordinate(6, 7));
        System.out.println(coordinates);
        final boolean expected = true;
        final boolean actual = StraightLineChecker.isOnStraightLine(coordinates);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isOnLine_False() {
        final List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(1, 1));
        coordinates.add(new Coordinate(2, 2));
        coordinates.add(new Coordinate(3, 4));
        coordinates.add(new Coordinate(4, 5));
        coordinates.add(new Coordinate(5, 6));
        coordinates.add(new Coordinate(6, 7));
        System.out.println(coordinates);
        final boolean expected = false;
        final boolean actual = StraightLineChecker.isOnStraightLine(coordinates);
        Assert.assertEquals(expected, actual);
    }
}