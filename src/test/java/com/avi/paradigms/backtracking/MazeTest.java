package com.avi.paradigms.backtracking;


import com.avi.paradigms.backtracking.Maze;
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
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
            Assert.assertFalse(solveUsingCountPath);
        }

        {
            final int[][] maze = null;
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
            Assert.assertFalse(solveUsingCountPath);
        }

        {
            final int[][] maze = {
                    {1, 0, 1, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 1}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertTrue(solve);
            Assert.assertTrue(solveUsingSolutionMatrix);
            Assert.assertTrue(solveUsingCountPath);;
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
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertTrue(solve);
            Assert.assertTrue(solveUsingSolutionMatrix);
            Assert.assertTrue(solveUsingCountPath);
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
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertTrue(solve);
            Assert.assertTrue(solveUsingSolutionMatrix);
            Assert.assertTrue(solveUsingCountPath);
        }

        {
            final int[][] maze = {
                    {1, 1, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 0, 1}
            };
            final boolean solve = solver.solve(maze);
            final boolean solveUsingSolutionMatrix = solver.solveUsingSolutionMatrix(maze);
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
            Assert.assertFalse(solveUsingCountPath);
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
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
            Assert.assertFalse(solveUsingCountPath);
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
            final boolean solveUsingCountPath = solver.solveUsingCountPath(maze);
            Assert.assertFalse(solve);
            Assert.assertFalse(solveUsingSolutionMatrix);
            Assert.assertFalse(solveUsingCountPath);
        }
    }

    @Test
    public void countPath() {
        {
            final int[][] maze = {};
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(0, numPaths);
        }

        {
            final int[][] maze = null;
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(0, numPaths);
        }

        {
            final int[][] maze = {
                    {1, 0, 1, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 1}
            };
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(1, numPaths);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0, 1},
                    {1, 1, 0, 1, 1},
                    {0, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1}
            };
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(1, numPaths);
        }

        {
            final int[][] maze = {
                    {1, 1, 0, 0, 1},
                    {1, 1, 0, 1, 1},
                    {1, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1}
            };
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(4, numPaths);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 0, 1}
            };
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(0, numPaths);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 0}
            };
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(0, numPaths);
        }

        {
            final int[][] maze = {
                    {1, 0, 0, 0, 1},
                    {1, 1, 0, 1, 1},
                    {0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1}
            };
            final int numPaths = solver.countPaths(maze);
            Assert.assertEquals(0, numPaths);
        }
    }
}