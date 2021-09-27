package com.avi.practice.company.google;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by navinash on 25/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ShortestPathHiddenGrid {

    private static final int SRC = 1;
    private static final int TARGET = 2;
    private static final int BLOCKED = -1;
    private static final int EMPTY = 0;
    private static final int PATH = 3;
    private static final int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };


    public int shortestPath(final int[][] grid, final int[] src, final int[] target) {
        final int m = grid.length;
        final int[] marker = new int[]{m + 2, m + 2};
        int distance = 0;
        final boolean[][] visited = new boolean[m][m];
        final Queue<int[]> q = new ArrayDeque<>();
        q.offer(src);
        q.offer(marker);
        while (!q.isEmpty()) {
            final int[] curr = q.poll();
            if (curr[0] == marker[0] && curr[1] == marker[1]) {
                if (!q.isEmpty()) {
                    q.offer(marker);
                    distance++;
                }
                continue;
            }
            if (curr[0] == target[0] && curr[1] == target[1]) {
                return distance;
            }
            if (visited[curr[0]][curr[1]]) {
                continue;
            }
            visited[curr[0]][curr[1]] = true;
            for (final int[] dir : dirs) {
                final int newX = dir[0] + curr[0];
                final int newY = dir[1] + curr[1];
                if (grid[newX][newY] != EMPTY && grid[newX][newY] != BLOCKED && !visited[newX][newY]) {
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }
}
