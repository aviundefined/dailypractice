package com.avi.practice.game.car;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 01/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CarFleetITest {

    @Test
    public void carFleet1() {
        final CarFleetI solver = new CarFleetI();
        final int target = 12;
        final int[] positions = {10,8,0,5,3};
        final int[] speed = {2,4,1,1,3};
        final int expected = 3;
        final int actual = solver.carFleet(target, positions, speed);
        Assert.assertEquals(expected, actual);
    }
}