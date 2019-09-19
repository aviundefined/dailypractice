package com.avi.practice.backtracking;

import com.avi.practice.utils.CommonUtils;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 19/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class Maze {

    final boolean solve(final int[][] maze) {
        System.out.println();
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            System.out.println("Maze is null or empty");
            System.out.println();
            return false;
        }
        final int m = maze.length;
        final int n = maze[0].length;
        CommonUtils.printMatrix(maze);
        if (maze[0][0] == 0 || maze[m - 1][n - 1] == 0) {
            System.out.println("No Solution found");
            return false;
        }
        final Set<Coordinate> sol = new LinkedHashSet<>();
        if (_solve(new Coordinate(0, 0), new Coordinate(m - 1, n - 1), maze, sol)) {
            System.out.println("Maze path: " + sol);
            return true;
        }
        System.out.println("No Solution found");
        return false;

    }

    final boolean solveUsingSolutionMatrix(final int[][] maze) {
        System.out.println();
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            System.out.println("Maze is null or empty");
            System.out.println();
            return false;
        }
        final int m = maze.length;
        final int n = maze[0].length;
        CommonUtils.printMatrix(maze);
        if (maze[0][0] == 0 || maze[m - 1][n - 1] == 0) {
            System.out.println("No Solution found");
            return false;
        }
        final int[][] sol = new int[m][n];
        if (_solve(new Coordinate(0, 0), new Coordinate(m - 1, n - 1), maze, sol)) {
            System.out.println("Solution");
            CommonUtils.printMatrix(sol);
            return true;
        }
        System.out.println("No Solution found");
        return false;

    }

    final int countPaths(final int[][] maze) {
        System.out.println();
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            System.out.println("Maze is null or empty");
            System.out.println();
            return 0;
        }
        final int m = maze.length;
        final int n = maze[0].length;
        CommonUtils.printMatrix(maze);
        if (maze[0][0] == 0 || maze[m - 1][n - 1] == 0) {
            System.out.println("No Solution found");
            return 0;
        }
        final int[][] sol = new int[m][n];
        sol[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (maze[i][0] == 1) {
                sol[i][0] = 1;
            } else {
                break;
            }
        }
        for (int j = 1; j < n; j++) {
            if (maze[0][j] == 1) {
                sol[0][j] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (maze[i][j] == 1) {
                    sol[i][j] = sol[i - 1][j] + sol[i][j - 1];
                }
            }
        }
        CommonUtils.printMatrix(sol);
        return Math.max(sol[m - 1][n - 1], 0);

    }

    private boolean _solve(
            final Coordinate start,
            final Coordinate end,
            final int[][] maze,
            final Set<Coordinate> sol) {
        if (start.equals(end)) {
            sol.add(start);
            return true;
        }

        if (_isSafe(start.x, start.y, maze)) {
            sol.add(start);
            if (_solve(new Coordinate(start.x + 1, start.y), end, maze, sol)
                    || _solve(new Coordinate(start.x, start.y + 1), end, maze, sol)) {
                return true;
            }
            sol.remove(start);
            return false;
        }
        return false;
    }

    private boolean _solve(
            final Coordinate start,
            final Coordinate end,
            final int[][] maze,
            final int[][] sol) {
        if (start.equals(end)) {
            sol[start.x][start.y] = 1;
            return true;
        }

        if (_isSafe(start.x, start.y, maze)) {
            sol[start.x][start.y] = 1;
            if (_solve(new Coordinate(start.x + 1, start.y), end, maze, sol)
                    || _solve(new Coordinate(start.x, start.y + 1), end, maze, sol)) {
                return true;
            }
            sol[start.x][start.y] = 0;
            return false;
        }
        return false;
    }

    private boolean _isSafe(final int x, final int y, final int[][] maze) {
        return x >= 0 && x < maze.length  // x within bound
                && y >= 0 && y < maze[0].length  // y with bound
                && maze[x][y] == 1; // path not blocked
    }

    private static final class Coordinate {
        private final int x;
        private final int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
