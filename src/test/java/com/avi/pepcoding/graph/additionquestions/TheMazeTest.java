package com.avi.pepcoding.graph.additionquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 06/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TheMazeTest {

    @Test
    public void hasPath_MyApproach1() {
        final TheMaze solver = new TheMaze();
        final int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        final int[] start = {0, 4};
        final int[] destination = {4, 4};
        final boolean expected = true;
        final boolean actual = solver.hasPath_MyApproach(maze, start, destination);
        for (final int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        System.out.println("Start:" + Arrays.toString(start));
        System.out.println("Destination:" + Arrays.toString(destination));
        Assert.assertEquals(expected, actual);
        System.out.println("------------");
    }

    @Test
    public void hasPath_MyApproach2() {
        final TheMaze solver = new TheMaze();
        final int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        final int[] start = {0, 4};
        final int[] destination = {3, 2};
        final boolean expected = false;
        final boolean actual = solver.hasPath_MyApproach(maze, start, destination);
        for (final int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        System.out.println("Start:" + Arrays.toString(start));
        System.out.println("Destination:" + Arrays.toString(destination));
        Assert.assertEquals(expected, actual);
        System.out.println("------------");
    }

    @Test
    public void hasPath_MyApproach3() {
        final TheMaze solver = new TheMaze();
        final int[][] maze = {{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        final int[] start = {4, 3};
        final int[] destination = {0, 1};
        final boolean expected = false;
        final boolean actual = solver.hasPath_MyApproach(maze, start, destination);
        for (final int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        System.out.println("Start:" + Arrays.toString(start));
        System.out.println("Destination:" + Arrays.toString(destination));
        Assert.assertEquals(expected, actual);
        System.out.println("------------");
    }

    @Test
    public void hasPath_MyApproach4() {
        final TheMaze solver = new TheMaze();
        final int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        final int[] start = {0, 4};
        final int[] destination = {1, 2};
        final boolean expected = true;
        final boolean actual = solver.hasPath_MyApproach(maze, start, destination);
        for (final int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
        System.out.println("Start:" + Arrays.toString(start));
        System.out.println("Destination:" + Arrays.toString(destination));
        Assert.assertEquals(expected, actual);
        System.out.println("------------");
    }
}