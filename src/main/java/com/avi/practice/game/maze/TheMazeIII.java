package com.avi.practice.game.maze;

import java.util.PriorityQueue;

/**
 * Created by navinash on 23/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TheMazeIII {

    // Lexiographical: d,l,r,u
    private static final int[][] dirs = {
            {1, 0},  // d
            {0, -1}, // l
            {0, 1},  // r
            {-1, 0}  // u
    };

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0 || ball == null || hole == null) {
            return "impossible";
        }
        if (ball[0] == hole[0] && ball[1] == hole[1]) {
            return "";
        }

        final boolean[][] visited = new boolean[maze.length][maze[0].length];
        final PriorityQueue<Cell> q = new PriorityQueue<>();
        q.offer(new Cell(ball[0], ball[1], 0, ""));
        while (!q.isEmpty()) {
            // remove mark* work add*
            final Cell curr = q.poll();

            if (visited[curr.x][curr.y]) {
                continue;
            }
            visited[curr.x][curr.y] = true;
            if (curr.x == hole[0] && curr.y == hole[1]) {
                return curr.path;
            }
            final int currDir = getDirection(curr.path);
            for (int i = 0; i < dirs.length; i++) {
                final int newX = curr.x + dirs[i][0];
                final int newY = curr.y + dirs[i][1];
                if (newX >= 0
                        && newY >= 0
                        && newX < maze.length
                        && newY < maze[0].length
                        && maze[newX][newY] == 0
                        && !visited[newX][newY]) {
                    String newPath = curr.path;
                    if (currDir == -1 || currDir != i) {
                        newPath += getPath(i);
                    }
                    q.offer(new Cell(newX, newY, curr.cost + 1, newPath));
                }
            }
        }
        return "impossible";
    }


    private String getPath(final int dir) {
        switch (dir) {
            case 0:
                return "d";
            case 1:
                return "l";
            case 2:
                return "r";
            case 3:
                return "u";
            default:
                return "";
        }
    }

    private int getDirection(final String path) {
        if (path == null || path.trim().length() == 0 || "".equals(path.trim())) {
            return -1;
        }

        final char lastChar = path.charAt(path.length() - 1);
        switch (lastChar) {
            case 'd':
                return 0;
            case 'l':
                return 1;
            case 'r':
                return 2;
            case 'u':
                return 3;
            default:
                return -1;
        }
    }


    private static final class Cell implements Comparable<Cell> {
        private final int x;
        private final int y;
        private final int cost;
        private final String path;

        private Cell(final int x, final int y, final int cost, final String path) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.path = path;
        }

        public int compareTo(final Cell cell) {
            if (this.cost == cell.cost) {
                return this.path.compareTo(cell.path);
            }
            return this.cost - cell.cost;
        }
    }
}
