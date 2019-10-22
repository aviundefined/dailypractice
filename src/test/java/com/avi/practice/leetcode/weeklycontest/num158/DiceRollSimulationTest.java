package com.avi.practice.leetcode.weeklycontest.num158;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by navinash on 23/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class DiceRollSimulationTest {

    @Test
    public void dieSimulator() {
        final DiceRollSimulation solver = new DiceRollSimulation();
        {
            final int n = 1;
            final int[] rollMax = {1, 1, 2, 2, 2, 3};
            final int output = 6;
            final int expected = solver.dieSimulator(n, rollMax);
            Assert.assertEquals(output, expected);
        }
        {
            final int n = 2;
            final int[] rollMax = {1, 1, 1, 1, 1, 1};
            final int output = 30;
            final int expected = solver.dieSimulator(n, rollMax);
            Assert.assertEquals(output, expected);
        }
        {
            final int n = 2;
            final int[] rollMax = {1, 1, 2, 2, 2, 3};
            final int output = 34;
            final int expected = solver.dieSimulator(n, rollMax);
            Assert.assertEquals(output, expected);
        }
        {
            final int n = 3;
            final int[] rollMax = {1, 1, 1, 1, 1, 1};
            final int output = 150;
            final int expected = solver.dieSimulator(n, rollMax);
            Assert.assertEquals(output, expected);
        }
        {
            final int n = 3;
            final int[] rollMax = {1, 1, 2, 2, 2, 3};
            final int output = 191;
            final int expected = solver.dieSimulator(n, rollMax);
            Assert.assertEquals(output, expected);
        }
    }
}