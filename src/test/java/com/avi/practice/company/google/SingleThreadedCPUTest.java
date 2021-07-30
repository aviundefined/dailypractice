package com.avi.practice.company.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 30/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SingleThreadedCPUTest {

    @Test
    public void getOrder1() {
        final SingleThreadedCPU solver = new SingleThreadedCPU();
        final int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        for (int i = 0; i < tasks.length; i++) {
            System.out.printf("id: %s, enqueueTime: %s, processingTime: %s\n", i, tasks[i][0], tasks[i][1]);
        }
        final int[] expected = {0, 2, 3, 1};
        final int[] actual = solver.getOrder(tasks);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        System.out.println("-----------------");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getOrder2() {
        final SingleThreadedCPU solver = new SingleThreadedCPU();
        final int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        for (int i = 0; i < tasks.length; i++) {
            System.out.printf("id: %s, enqueueTime: %s, processingTime: %s\n", i, tasks[i][0], tasks[i][1]);
        }
        final int[] expected = {4, 3, 2, 0, 1};
        final int[] actual = solver.getOrder(tasks);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        System.out.println("-----------------");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getOrder3() {
        final SingleThreadedCPU solver = new SingleThreadedCPU();
        final int[][] tasks = {{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};
        for (int i = 0; i < tasks.length; i++) {
            System.out.printf("id: %s, enqueueTime: %s, processingTime: %s\n", i, tasks[i][0], tasks[i][1]);
        }
        final int[] expected = {6, 1, 2, 9, 4, 10, 0, 11, 5, 13, 3, 8, 12, 7};
        final int[] actual = solver.getOrder(tasks);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        System.out.println("-----------------");
        Assert.assertArrayEquals(expected, actual);
    }
}