package com.avi.pepcoding.graph.union_find;

/**
 * Created by navinash on 16/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class BricksFallingWhenHit {

    private static final int BRICK = 1;
    private static final int HIT = 2;
    private static final int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    private int[][] grid;
    private DSU dsu;
    private int rows;
    private int cols;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (hits == null || hits.length == 0) {
            return new int[]{};
        }
        final int[] result = new int[hits.length];
        if (grid == null || grid.length == 0) {
            return result;
        }
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        dsu = new DSU(rows, cols);
        // mark all hits having brick with HIT
        for (final int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == BRICK) {
                grid[hit[0]][hit[1]] = HIT;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == BRICK) {
                    unionAdjacent(i, j);
                }
            }
        }
        int stableBricks = dsu.size(0);
        for (int i = hits.length - 1; i >= 0; i--) {
            final int x = hits[i][0];
            final int y = hits[i][1];
            if (grid[x][y] != HIT) {
                result[i] = 0;
                continue;
            }
            grid[x][y] = BRICK;
            unionAdjacent(x, y);
            final int newStableBricks = dsu.size(0);
            result[i] = Math.max(newStableBricks - stableBricks - 1, 0);
            stableBricks = newStableBricks;
        }
        return result;
    }

    private void unionAdjacent(final int x, final int y) {
        final int node1 = cols * x + y + 1;
        for (final int[] dir : dirs) {
            final int newX = dir[0] + x;
            final int newY = dir[1] + y;
            if (newX < 0 || newY < 0 || newX >= rows || newY >= cols || grid[newX][newY] != BRICK) {
                continue;
            }
            dsu.union(node1, cols * newX + newY + 1);
        }

        // top row connect with wall
        if (x == 0) {
            dsu.union(0, node1);
        }
    }

    private static final class DSU {
        private final int[] parent;
        private final int[] rank;
        private final int[] counts;

        private DSU(final int rows, int cols) {
            final int size = rows * cols + 1;
            this.parent = new int[size];
            this.counts = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                this.parent[i] = i;
                this.counts[i] = 1;
                this.rank[i] = 0;
            }
            this.counts[0] = 0;
            this.rank[0] = 1;
        }

        private int find(final int index) {
            if (parent[index] == index) {
                return index;
            }
            final int tmp = find(parent[index]);
            parent[index] = tmp;
            return tmp;
        }

        private boolean union(final int node1, final int node2) {
            final int parent1 = find(node1);
            final int parent2 = find(node2);
            if (parent1 == parent2) {
                return false;
            }
            if (this.rank[parent1] == this.rank[parent2]) {
                if (parent1 == 0 || this.counts[parent1] >= this.counts[parent2]) {
                    this.parent[parent2] = parent1;
                    this.counts[parent1] += this.counts[parent2];
                    this.rank[parent1]++;
                } else {
                    this.parent[parent1] = parent2;
                    this.counts[parent2] += this.counts[parent1];
                    this.rank[parent2]++;
                }
            } else if (this.rank[parent1] > this.rank[parent2]) {
                this.parent[parent2] = parent1;
                this.counts[parent1] += this.counts[parent2];
            } else {
                this.parent[parent1] = parent2;
                this.counts[parent2] += this.counts[parent1];
            }
            return true;
        }

        private int size(final int node) {
            return this.counts[find(0)];
        }
    }
}
