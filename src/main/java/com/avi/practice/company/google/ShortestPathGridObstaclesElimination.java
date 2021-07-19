package com.avi.practice.company.google;

import java.util.PriorityQueue;

/**
 * Created by navinash on 19/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShortestPathGridObstaclesElimination {

    private static final int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, -1},
            {0, 1}
    };

    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0][0] == 1 && k <= 0) {
            return -1;
        }
        final int m = grid.length;
        final int n = grid[0].length;
        final boolean[][][] visited = new boolean[m][n][k + 1];

        final PriorityQueue<Cell> q = new PriorityQueue<>();
        if (grid[0][0] == 0) {
            q.offer(new Cell(0, 0, 0, k));
        } else {
            q.offer(new Cell(0, 0, 0, k - 1));
        }

        while (!q.isEmpty()) {
            // remove mark* work add*
            final Cell curr = q.poll();
            if (curr.x == m - 1 && curr.y == n - 1) {
                return curr.cost;
            }
            if (visited[curr.x][curr.y][curr.numsRemove]) {
                continue;
            }
            visited[curr.x][curr.y][curr.numsRemove] = true;
            for (final int[] dir : dirs) {
                final int newX = curr.x + dir[0];
                final int newY = curr.y + dir[1];
                if (newX < 0
                        || newY < 0
                        || newX >= m
                        || newY >= n
                        || visited[newX][newY][curr.numsRemove]) {
                    continue;
                }
                if (grid[newX][newY] == 0) {
                    q.offer(new Cell(newX, newY, curr.cost + 1, curr.numsRemove));
                } else if (grid[newX][newY] == 1 && curr.numsRemove >= 1) {
                    q.offer(new Cell(newX, newY, curr.cost + 1, curr.numsRemove - 1));
                }
            }
        }
        return -1;

    }

    private static final class Cell implements Comparable<Cell> {
        private final int x;
        private final int y;
        private final int cost;
        private final int numsRemove;

        public Cell(int x, int y, int cost, int numsRemove) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.numsRemove = numsRemove;
        }

        @Override
        public int compareTo(Cell o) {
            if (this.cost == o.cost) {
                return o.numsRemove - this.numsRemove;
            }
            return this.cost - o.cost;
        }
    }
}
