package com.avi.practice.game.maze;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by navinash on 23/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TheMazeIIITest {

    @Test
    public void findShortestWay1() {
        final TheMazeIII solver = new TheMazeIII();
        final int[][] maze = {{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        final int[] ball = {4, 3};
        final int[] hole = {0, 1};
        for (final int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Ball: " + Arrays.toString(ball));
        System.out.println("Hole: " + Arrays.toString(hole));
        System.out.println("-------------");
        final String actual = "lul";
        final String expected = solver.findShortestWay(maze, ball, hole);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void findShortestWay2() {
        final TheMazeIII solver = new TheMazeIII();
        final int[][] maze = {{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        final int[] ball = {4, 3};
        final int[] hole = {3, 0};
        for (final int[] row : maze) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Ball: " + Arrays.toString(ball));
        System.out.println("Hole: " + Arrays.toString(hole));
        System.out.println("-------------");
        final String actual = "impossible";
        final String expected = solver.findShortestWay(maze, ball, hole);
        Assert.assertEquals(actual, expected);
    }

}