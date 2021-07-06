package com.avi.pepcoding.graph.additionquestions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by navinash on 06/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TheMaze {
    private static final int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public boolean hasPath_MyApproach(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        final Set<Cell> visited = new HashSet<>();
        return dfs(start[0], start[1], destination[0], destination[1], visited, maze, 0);
    }

    private boolean dfs(
            final int sr,
            final int sc,
            final int dr,
            final int dc,
            final Set<Cell> visited,
            final int[][] maze,
            int currentDirection) {

        if (sr == dr && sc == dc) {
            System.out.println("Reached destination from dir: " + currentDirection);
            // reached destination now check if ball will stop here
            if (canStop(dr, dc, currentDirection, maze)) {
                return true;
            }
        }
        if (sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] != 0 || visited.contains(new Cell(sr, sc))) {
            return false;
        }


        visited.add(new Cell(sr, sc));
        for (int n = 0; n < directions.length; n++) {
            final int newSR = sr + directions[currentDirection][0];
            final int newSC = sc + directions[currentDirection][1];
            if (newSR >= 0 && newSC >= 0
                    && newSR < maze.length && newSC < maze[0].length
                    && !visited.contains(new Cell(newSR, newSC))
                    && maze[newSR][newSC] != 1) {
                final boolean reached = dfs(newSR, newSC, dr, dc, visited, maze, currentDirection);
                if (reached) {
                    return true;
                }
            }
            currentDirection = (currentDirection + 1) % directions.length;
        }
        return false;
    }

    private boolean canStop(int dr, int dc, int currentDirection, int[][] maze) {
        final int nextRow = dr + directions[currentDirection][0];
        final int nextCol = dc + directions[currentDirection][1];
        if (nextRow < 0 || nextCol < 0 || nextRow >= maze.length || nextCol >= maze[0].length || maze[nextRow][nextCol] == 1) {
            return true;
        }
        return false;
    }

    private static final class Cell {
        private final int i;
        private final int j;

        private Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return i == cell.i &&
                    j == cell.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
