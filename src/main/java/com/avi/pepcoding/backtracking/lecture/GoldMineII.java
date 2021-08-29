package com.avi.pepcoding.backtracking.lecture;

/**
 * Created by navinash on 23/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class GoldMineII {
    private static final int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    private int[][] goldMine;
    private boolean[][] visited;
    public int maxGold(final int[][] goldMine) {
        if (goldMine == null || goldMine.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        this.goldMine = goldMine;
        this.visited = new boolean[goldMine.length][goldMine[0].length];
        for (int i = 0; i < goldMine.length; i++) {
            for (int j = 0; j < goldMine[0].length; j++) {
                if (goldMine[i][j] != 0 && !this.visited[i][j]) {
                    final int curr = backtrack(i, j);
                    if (curr > max) {
                        max = curr;
                    }
                }
            }
        }
        return max;
    }

    private int backtrack(int i, int j) {
        if (i < 0 || j < 0 || i >= this.goldMine.length || j >= this.goldMine[0].length || this.goldMine[i][j] == 0 || this.visited[i][j]) {
            return 0;
        }
        this.visited[i][j] = true;
        int value = this.goldMine[i][j];
        for (final int[] dir : dirs) {
            final int newI = i + dir[0];
            final int newJ = j + dir[1];
            value += backtrack(newI, newJ);
        }
        return value;
    }
}
