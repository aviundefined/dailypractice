package com.avi.pepcoding.graph.union_find;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navinash on 17/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MakingLargeIsland {
    private static final int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    private int m;
    private int n;
    private int[][] grid;

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        final DSU dsu = new DSU(m * n);
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    final int node1 = n * i + j;
                    for (final int[] dir : dirs) {
                        final int newX = i + dir[0];
                        final int newY = j + dir[1];
                        if (newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] == 0) {
                            continue;
                        }
                        dsu.union(node1, n * newX + newY);
                        max = Math.max(max, dsu.count(dsu.find(node1)));
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    final Set<Integer> newConnectedParents = new HashSet<>();
                    for (final int[] dir : dirs) {
                        final int newX = i + dir[0];
                        final int newY = j + dir[1];
                        if (newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] == 0) {
                            continue;
                        }
                        final int node = newX * n + newY;
                        final int parent = dsu.find(node);
                        newConnectedParents.add(parent);
                    }
                    int connectedNodes = 1;
                    for (final int parent : newConnectedParents) {
                        connectedNodes += dsu.count(parent);
                    }
                    max = Math.max(max, connectedNodes);
                }
            }
        }

        return max;
    }

    private static final class DSU {
        private final int[] parent;
        private final int[] rank;
        private final int[] counts;

        private DSU(final int size) {
            this.parent = new int[size];
            this.rank = new int[size];
            this.counts = new int[size];
            for (int i = 0; i < size; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
                this.counts[i] = 1;
            }
        }

        private int find(final int node) {
            if (parent[node] == node) {
                return node;
            }
            final int tmp = find(parent[node]);
            parent[node] = tmp;
            return tmp;
        }

        private boolean union(final int node1, final int node2) {
            final int parent1 = find(node1);
            final int parent2 = find(node2);
            if (parent1 == parent2) {
                return false;
            }
            if (this.rank[parent1] > this.rank[parent2]) {
                this.parent[parent2] = parent1;
                this.counts[parent1] += this.counts[parent2];
            } else if (this.rank[parent2] > this.rank[parent1]) {
                this.parent[parent1] = parent2;
                this.counts[parent2] += this.counts[parent1];
            } else {
                this.parent[parent2] = parent1;
                this.counts[parent1] += this.counts[parent2];
                this.rank[parent1]++;
            }
            return true;
        }

        private int count(final int node) {
            return this.counts[node];
        }
    }
}
