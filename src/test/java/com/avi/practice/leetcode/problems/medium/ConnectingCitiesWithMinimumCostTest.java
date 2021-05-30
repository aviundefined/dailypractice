package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 30/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ConnectingCitiesWithMinimumCostTest {
    private static final ConnectingCitiesWithMinimumCost solver =new ConnectingCitiesWithMinimumCost();

    @Test
    public void minimumCost1() {
        final int n = 3;
        final int[][] connections = {
                {1, 2, 5},
                {1, 3, 6},
                {2, 3, 1}
        };
        final int expected = 6;
        System.out.println("Number of cities: "+n);
        for(final int[] connection : connections){
            System.out.println(Arrays.toString(connection));
        }
        System.out.println("---------------");
        final int actual = solver.minimumCost(n, connections);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minimumCost2() {
        final int n = 4;
        final int[][] connections = {
                {1,2,3},
                {3,4,4},
        };
        final int expected = -1;
        System.out.println("Number of cities: "+n);
        for(final int[] connection : connections){
            System.out.println(Arrays.toString(connection));
        }
        System.out.println("---------------");
        final int actual = solver.minimumCost(n, connections);
        Assert.assertEquals(expected, actual);
    }
}