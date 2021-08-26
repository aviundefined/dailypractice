package com.avi.practice.company.google;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

/**
 * Created by navinash on 26/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ProcessTasksUsingServersTest extends TestCase {

    public void testAssignTasks1() {
        final ProcessTasksUsingServers solver = new ProcessTasksUsingServers();
        final int[] servers = {3, 3, 2};
        final int[] tasks = {1, 2, 3, 2, 1, 2};
        final int[] expected = {2, 2, 0, 2, 1, 2};
        final int[] actual = solver.assignTasks(servers, tasks);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }

    public void testAssignTasks2() {
        final ProcessTasksUsingServers solver = new ProcessTasksUsingServers();
        final int[] servers = {1, 2, 3};
        final int[] tasks = {5, 4, 3, 1, 2};
        final int[] expected = {0, 1, 2, 0, 1};
        final int[] actual = solver.assignTasks(servers, tasks);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }
}