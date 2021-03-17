package com.avi.practice.leetcode.weeklycontest.num222;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 06/01/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CountGoodMealsTest {

    private static CountGoodMeals solver = new CountGoodMeals();

    @Test
    public void countPairs1() {
        final int[] deliciousness = {1, 3, 5, 7, 9};
        final int expected = 4;
        final int actual = solver.countPairs(deliciousness);
        Assert.assertEquals(Arrays.toString(deliciousness), expected, actual);
    }

    @Test
    public void countPairs2() {
        final int[] deliciousness = {1,1,1,3,3,3,7};
        final int expected = 15;
        final int actual = solver.countPairs(deliciousness);
        Assert.assertEquals(Arrays.toString(deliciousness), expected, actual);
    }
}