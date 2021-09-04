package com.avi.practice.leetcode.daily;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

/**
 * Created by navinash on 04/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SumOfDistancesInTreeTest extends TestCase {

    public void testSumOfDistancesInTree_BruteForce1() {
        final SumOfDistancesInTree solver = new SumOfDistancesInTree();
        final int n = 6;
        final int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        final int[] actual = {8, 12, 6, 10, 10, 10};
        final int[] expected = solver.sumOfDistancesInTree_BruteForce(n, edges);
        System.out.println("Actual: " + Arrays.toString(actual));
        System.out.println("Expected: " + Arrays.toString(expected));
        Assert.assertArrayEquals(expected, actual);
    }

    public void testSumOfDistancesInTree_BruteForce2() {
        final SumOfDistancesInTree solver = new SumOfDistancesInTree();
        final int n = 6;
        final int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        final int[] actual = {8, 12, 6, 10, 10, 10};
        final int[] expected = solver.sumOfDistancesInTree_BruteForce(n, edges);
        System.out.println("Actual: " + Arrays.toString(actual));
        System.out.println("Expected: " + Arrays.toString(expected));
        Assert.assertArrayEquals(expected, actual);
    }
}