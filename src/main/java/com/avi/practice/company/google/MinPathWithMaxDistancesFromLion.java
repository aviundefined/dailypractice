package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by navinash on 21/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MinPathWithMaxDistancesFromLion {
    private static final Cell marker = new Cell(-1, -1, -1);
    private static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int path(final int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        final int m = arr.length;
        final int n = arr[0].length;

        final int[][] minDistanceFromLion = new int[m][n];
        final Queue<Cell> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    q.offer(new Cell(i, j, 0));
                }
            }
        }
        q.offer(marker);

        boolean[][] visited = new boolean[m][n];
        int distanceFromLion = 0;
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Cell curr = q.poll();
            if (curr.equals(marker)) {
                if (!q.isEmpty()) {
                    distanceFromLion++;
                    q.offer(marker);
                }
            } else {
                if (visited[curr.x][curr.y]) {
                    continue;
                }
                minDistanceFromLion[curr.x][curr.y] = distanceFromLion;
                visited[curr.x][curr.y] = true;
                for (final int[] direction : directions) {
                    final int newX = curr.x + direction[0];
                    final int newY = curr.y + direction[1];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY] && arr[newX][newY] != 0) {
                        q.offer(new Cell(newX, newY, distanceFromLion));
                    }
                }
            }
        }
        for (final int[] row : minDistanceFromLion) {
            System.out.println(Arrays.toString(row));
        }

        visited = new boolean[m][n];

        final PriorityQueue<CellWithWeight> pq = new PriorityQueue<>();
        final CellWithWeight start = new CellWithWeight(new Cell(0, 0, minDistanceFromLion[0][0]), arr[0][0]);
        pq.offer(start);
        int minCost = 0;
        while (!pq.isEmpty()) {
            // remove mark* work add*
            final CellWithWeight curr = pq.poll();
            if (curr.cell.x == m - 1 && curr.cell.y == n - 1) {
                minCost = curr.weight;
                break;
            }
            if (visited[curr.cell.x][curr.cell.y]) {
                continue;
            }
            visited[curr.cell.x][curr.cell.y] = true;
            for (final int[] direction : directions) {
                final int newX = curr.cell.x + direction[0];
                final int newY = curr.cell.y + direction[1];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY] && arr[newX][newY] != 0) {
                    pq.offer(new CellWithWeight(new Cell(newX, newY, minDistanceFromLion[newX][newY]), curr.weight + arr[newX][newY]));
                }
            }
        }
        return minCost;
    }


    private static final class Cell {
        private final int x;
        private final int y;
        private final int distanceFromLion;

        private Cell(int x, int y, int distanceFromLion) {
            this.x = x;
            this.y = y;
            this.distanceFromLion = distanceFromLion;
        }

        @Override
        public String toString() {
            return "" + distanceFromLion;
        }
    }

    private static final class CellWithWeight implements Comparable<CellWithWeight> {
        private final Cell cell;
        private final int weight;

        public CellWithWeight(Cell cell, int weight) {
            this.cell = cell;
            this.weight = weight;
        }

        @Override
        public int compareTo(CellWithWeight o) {
            if (o.cell.distanceFromLion == this.cell.distanceFromLion) {
                return this.weight - o.weight;
            }
            return o.cell.distanceFromLion - this.cell.distanceFromLion;
        }
    }
}
