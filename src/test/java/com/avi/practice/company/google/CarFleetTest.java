package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CarFleetTest {
    private static final CarFleet solver = new CarFleet();

    @Test
    public void carFleet() {
        final int[] position = {10,8,0,5,3};
        final int[] speed = {2,4,1,1,3};
        final int target = 12;
        final int expected = 3;
        final int actual = solver.carFleet(target, position, speed);
        Assert.assertEquals(expected, actual);
    }
}