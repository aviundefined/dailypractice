package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 26/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GasStationTest {

    private static final GasStation solver = new GasStation();

    @Test
    public void canCompleteCircuit1() {
        final int[] gas = {5, 1, 2, 3, 4};
        final int[] cost = {4, 4, 1, 5, 1};
        final int expected = 4;
        final int actual = solver.canCompleteCircuit(gas, cost);
        Assert.assertEquals(String.format("gas: %s, cost: %s", Arrays.toString(gas), Arrays.toString(cost)), expected, actual);
    }
}