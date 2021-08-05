package com.avi.practice.leetcode.monthly.august2021;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by navinash on 04/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class OptimizeWaterDistributionVillageTest {

    @Test
    public void minCostToSupplyWater1() {
        final OptimizeWaterDistributionVillage solver = new OptimizeWaterDistributionVillage();
        final int n = 3;
        final int[] wells = {1,2,2};
        final int[][] pipes = {{1,2,1},{2,3,1}};
        final int expected = 3;
        final int actual = solver.minCostToSupplyWater(n, wells, pipes);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minCostToSupplyWater2() {
        final OptimizeWaterDistributionVillage solver = new OptimizeWaterDistributionVillage();
        final int n = 5;
        final int[] wells = {46012,72474,64965,751,33304};
        final int[][] pipes = {{2,1,6719},{3,2,75312},{5,3,44918}};
        final int expected = 131704;
        final int actual = solver.minCostToSupplyWater(n, wells, pipes);
        Assert.assertEquals(expected, actual);
    }
}