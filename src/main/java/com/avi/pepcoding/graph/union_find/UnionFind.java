package com.avi.pepcoding.graph.union_find;

/**
 * Created by navinash on 16/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class UnionFind {

    private final int[] parent;
    private final int[] rank;
    private int count;

    public UnionFind(final int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        this.parent = new int[row * col];
        this.rank = new int[row * col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    parent[row * i + j] = row * i + j;
                    count++;
                }
                this.rank[row * i + j] = 0;
            }
        }
    }

    public int find(final int node) {
        if (parent[node] == node) {
            return node;
        }
        final int tmp = find(parent[node]);
        parent[node] = tmp;
        return tmp;
    }

    public boolean union(final int node1, final int node2) {
        final int parent1 = find(node1);
        final int parent2 = find(node2);
        if (parent1 == parent2) {
            return false;
        }

        if (rank[parent1] == rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1]++;
        } else if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
        count--;
        return true;
    }

    public int getCount() {
        return this.count;
    }
}
