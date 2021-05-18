package com.avi.practice.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by navinash on 18/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class CourseScheduleTest {

    private final static CourseSchedule solver = new CourseSchedule();

    @Test
    public void findOrder1() {
        final int numCourses = 2;
        final int[][] prerequisites = {
                {1, 0}
        };
        final int[] expected = {0, 1};
        final int[] actual = solver.findOrder(numCourses, prerequisites);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findOrder2() {
        final int numCourses = 4;
        final int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        final int[] expected = {0, 1, 2, 3};
        final int[] actual = solver.findOrder(numCourses, prerequisites);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findOrder3() {
        final int numCourses = 1;
        final int[][] prerequisites = {};
        final int[] expected = {0};
        final int[] actual = solver.findOrder(numCourses, prerequisites);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findOrder4() {
        final int numCourses = 2;
        final int[][] prerequisites = {
                {0, 1},
                {1, 0},
        };
        final int[] expected = {};
        final int[] actual = solver.findOrder(numCourses, prerequisites);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }
}