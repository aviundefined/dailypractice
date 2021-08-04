package com.avi.practice.leetcode.monthly.august2021;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by navinash on 04/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MakingALargeIsland {

    private static final int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        return new Solver(grid).solve();
    }

    private static final class Solver {
        private final int[][] grid;
        private final int m;
        private final int n;
        private final Map<Integer, Integer> areaByColor = new HashMap<>();

        private Solver(int[][] grid) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
        }

        public int solve() {
            // do bfs from each cell whose value is 1 and color each cell with unique color
            // after that from each cell whose value is 9 check the adjacent colors and get the max area for each adjacent color
            int color = 2;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        bfs(i, j, color);
                        color++;
                    }
                }
            }
            int max = 0;
            boolean isAnyZero = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        isAnyZero = true;
                        final Set<Integer> colorsUsed = new HashSet<>();
                        int area = 1;
                        for (final int[] dir : dirs) {
                            final int x = i + dir[0];
                            final int y = j + dir[1];
                            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 0) {
                                final int adjColor = grid[x][y];
                                if (colorsUsed.add(adjColor)) {
                                    area += areaByColor.getOrDefault(adjColor, 0);
                                }
                            }
                        }
                        max = Math.max(area, max);
                    }
                }
            }
            return isAnyZero  ? max : m * n ;
        }

        private void bfs(int i, int j, int color) {
            int area = 0;
            final Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{i, j});
            while (!q.isEmpty()) {
                // remove mark* work add*
                final int[] curr = q.poll();
                if (grid[curr[0]][curr[1]] == 1) {
                    grid[curr[0]][curr[1]] = color;
                    area++;
                    for (final int[] dir : dirs) {
                        final int x = curr[0] + dir[0];
                        final int y = curr[1] + dir[1];
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
            areaByColor.put(color, area);
        }
    }

}
