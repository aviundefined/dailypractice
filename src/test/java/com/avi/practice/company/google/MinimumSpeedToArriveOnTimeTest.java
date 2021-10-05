package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 05/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinimumSpeedToArriveOnTimeTest {

    @Test
    public void minSpeedOnTime1() {
        final MinimumSpeedToArriveOnTime solver = new MinimumSpeedToArriveOnTime();
        final int[] dist = {1, 3, 2};
        final double hour = 6D;
        final int expected = 1;
        final int actual = solver.minSpeedOnTime(dist, hour);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minSpeedOnTime2() {
        final MinimumSpeedToArriveOnTime solver = new MinimumSpeedToArriveOnTime();
        final int[] dist = {1, 3, 2};
        final double hour = 2.7D;
        final int expected = 3;
        final int actual = solver.minSpeedOnTime(dist, hour);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minSpeedOnTime3() {
        final MinimumSpeedToArriveOnTime solver = new MinimumSpeedToArriveOnTime();
        final int[] dist = {1, 3, 2};
        final double hour = 1.9;
        final int expected = -1;
        final int actual = solver.minSpeedOnTime(dist, hour);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minSpeedOnTime4() {
        final MinimumSpeedToArriveOnTime solver = new MinimumSpeedToArriveOnTime();
        final int[] dist = {1, 1, 100000};
        final double hour = 2.01D;
        final int expected = 10000000;
        final int actual = solver.minSpeedOnTime(dist, hour);
        Assert.assertEquals(expected, actual);
    }
}