package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 21/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CampusBikesTest {

    @Test
    public void assignBikes_PriorityQueue_TLE1() {
        final CampusBikes solver = new CampusBikes();
        final int[][] workers  = {{0,0},{2,1}};
        final int[][] bikes = {{1,2},{3,3}};
        final int[] expected = {1, 0};
        final int[] actual = solver.assignBikes_PriorityQueue_TLE(workers, bikes);
        System.out.println("expected: "+ Arrays.toString(expected));
        System.out.println("actual: "+ Arrays.toString(actual));
        System.out.println("------------------");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void assignBikes_PriorityQueue_TLE2() {
        final CampusBikes solver = new CampusBikes();
        final int[][] workers  = {{0,0},{1,1},{2,0}};
        final int[][] bikes = {{1,0},{2,2},{2,1}};
        final int[] expected = {0, 2, 1};
        final int[] actual = solver.assignBikes_PriorityQueue_TLE(workers, bikes);
        System.out.println("expected: "+ Arrays.toString(expected));
        System.out.println("actual: "+ Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
        System.out.println("------------------");
    }
    @Test
    public void assignBikes1() {
        final CampusBikes solver = new CampusBikes();
        final int[][] workers  = {{0,0},{2,1}};
        final int[][] bikes = {{1,2},{3,3}};
        final int[] expected = {1, 0};
        final int[] actual = solver.assignBikes(workers, bikes);
        System.out.println("expected: "+ Arrays.toString(expected));
        System.out.println("actual: "+ Arrays.toString(actual));
        System.out.println("------------------");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void assignBikes2() {
        final CampusBikes solver = new CampusBikes();
        final int[][] workers  = {{0,0},{1,1},{2,0}};
        final int[][] bikes = {{1,0},{2,2},{2,1}};
        final int[] expected = {0, 2, 1};
        final int[] actual = solver.assignBikes(workers, bikes);
        System.out.println("expected: "+ Arrays.toString(expected));
        System.out.println("actual: "+ Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
        System.out.println("------------------");
    }
}