package com.avi.practice.game.maze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
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

    public boolean hasPath_BFS(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || start == null || destination == null) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        final boolean[][] visited = new boolean[maze.length][maze[0].length];
        while (!q.isEmpty()) {
            // remove mark* work add*
            final int[] curr = q.poll();
            if (visited[curr[0]][curr[1]]) {
                continue;
            }
            visited[curr[0]][curr[1]] = true;
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (final int[] dir : directions) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                while (newX >= 0
                        && newY >= 0
                        && newX < maze.length
                        && newY < maze[0].length
                        && maze[newX][newY] == 0) {
                    newX += dir[0];
                    newY += dir[1];
                }
                if (!visited[newX - dir[0]][newY - dir[1]]) {
                    q.offer(new int[]{newX - dir[0], newY - dir[1]});
                }
            }
        }
        return false;
    }

    public boolean hasPath_DFS(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        final Set<Cell> visited = new HashSet<>();
        return dfs(start[0], start[1], destination[0], destination[1], visited, maze);
    }

    private boolean dfs(int sr, int sc, int ds, int dc, Set<Cell> visited, int[][] maze) {
        if (sr == ds && sc == dc) {
            return true;
        }
        if (visited.contains(new Cell(sr, sc))) {
            return false;
        }
        visited.add(new Cell(sr, sc));
        int right = sc + 1;
        int left = sc - 1;
        int up = sr - 1;
        int down = sr + 1;
        while (right < maze[0].length && maze[sr][right] == 0) {
            right++;
        }
        if (dfs(sr, right - 1, ds, dc, visited, maze)) {
            return true;
        }
        while (left >= 0 && maze[sr][left] == 0) {
            left--;
        }
        if (dfs(sr, left + 1, ds, dc, visited, maze)) {
            return true;
        }
        while (up >= 0 && maze[up][sc] == 0) {
            up--;
        }
        if (dfs(up + 1, sc, ds, dc, visited, maze)) {
            return true;
        }
        while (down < maze.length && maze[down][sc] == 0) {
            down++;
        }
        if (dfs(down - 1, sc, ds, dc, visited, maze)) {
            return true;
        }
        return false;
    }

    public boolean hasPath_MyApproach(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        final Set<Cell> visited = new HashSet<>();
        return dfs_MyApproach(start[0], start[1], destination[0], destination[1], visited, maze, 0);
    }

    private boolean dfs_MyApproach(
            final int sr,
            final int sc,
            final int dr,
            final int dc,
            final Set<Cell> visited,
            final int[][] maze,
            int currentDirection) {

        if (sr == dr && sc == dc) {
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
                final boolean reached = dfs_MyApproach(newSR, newSC, dr, dc, visited, maze, currentDirection);
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
