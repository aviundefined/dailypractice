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
public class DivideChoclateTest {

    private static final DivideChoclate solver = new DivideChoclate();

    @Test
    public void divide1() {
        final int[] sweetness = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int k = 5;
        final int expected = 6;
        final int actual = solver.divide(sweetness, k);
        Assert.assertEquals(String.format("sweetness: %s, cuts: %d", Arrays.toString(sweetness), k), expected, actual);
    }

    @Test
    public void divide2() {
        final int[] sweetness = {1, 2, 2, 1, 2, 2, 1, 2, 2};
        final int k = 2;
        final int expected = 5;
        final int actual = solver.divide(sweetness, k);
        Assert.assertEquals(String.format("sweetness: %s, cuts: %d", Arrays.toString(sweetness), k), expected, actual);
    }

    @Test
    public void divide3() {
        final int[] sweetness = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        final int k = 8;
        final int expected = 1;
        final int actual = solver.divide(sweetness, k);
        Assert.assertEquals(String.format("sweetness: %s, cuts: %d", Arrays.toString(sweetness), k), expected, actual);
    }


    @Test
    public void isPossible1() {
        final int[] sweetness = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int k = 5;
        final int minSweetness = 6;
        final boolean expected = true;
        final boolean actual = solver.isPossible(sweetness, k, minSweetness);
        Assert.assertEquals(String.format("sweetness: %s, cuts: %d", Arrays.toString(sweetness), k), expected, actual);
    }

    @Test
    public void isPossible2() {
        final int[] sweetness = {1, 2, 2, 1, 2, 2, 1, 2, 2};
        final int k = 2;
        final int minSweetness = 5;
        final boolean expected = true;
        final boolean actual = solver.isPossible(sweetness, k, minSweetness);
        Assert.assertEquals(String.format("sweetness: %s, cuts: %d", Arrays.toString(sweetness), k), expected, actual);
    }

    @Test
    public void isPossible3() {
        final int[] sweetness = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        final int k = 8;
        final int minSweetness = 1;
        final boolean expected = true;
        final boolean actual = solver.isPossible(sweetness, k, minSweetness);
        Assert.assertEquals(String.format("sweetness: %s, cuts: %d", Arrays.toString(sweetness), k), expected, actual);
    }
}