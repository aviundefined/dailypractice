package com.avi.practice.backtracking;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MazeTest {

    private Maze solver;

    @Before
    public void setup() {
        solver = new Maze();
    }

    @After
    public void tearDown() {
        solver = null;
    }

    @Test
    public void testMaze() {
        {
            final int[][] maze = {};
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
        }

        {
            final int[][] maze = null;
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 1}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertTrue(solve);
            Assert.assertTrue(solveUsingSolutionMatrix);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0, 1},
                    {1, 1, 0, 1, 1},
                    {0, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertTrue(solve);
            Assert.assertTrue(solveUsingSolutionMatrix);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0, 1},
                    {1, 1, 0, 1, 1},
                    {1, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertTrue(solve);
            Assert.assertTrue(solveUsingSolutionMatrix);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 0, 1}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 0}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0, 1},
                    {1, 1, 0, 1, 1},
                    {0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
        }
    }
}