package com.avi.practice.game.maze;

import java.util.PriorityQueue;

/**
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.
 * <p>
 * The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
 * <p>
 * You may assume that the borders of the maze are all walls (see examples).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
 * Output: 12
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 * Example 2:
 * <p>
 * <p>
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
 * Output: -1
 * Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
 * Example 3:
 * <p>
 * Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == maze.length
 * n == maze[i].length
 * 1 <= m, n <= 100
 * maze[i][j] is 0 or 1.
 * start.length == 2
 * destination.length == 2
 * 0 <= startrow, destinationrow <= m
 * 0 <= startcol, destinationcol <= n
 * Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
 * The maze contains at least 2 empty spaces.
 */
public class TheMazeII {

    private static final int[][] dirs = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || start == null || destination == null) {
            return -1;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return 0;
        }

        final boolean[][] visited = new boolean[maze.length][maze[0].length];
        final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        q.offer(new int[]{start[0], start[1], 0});

        while (!q.isEmpty()) {
            // remove mark* work add*
            final int[] curr = q.poll();
            if (visited[curr[0]][curr[1]]) {
                continue;
            }
            visited[curr[0]][curr[1]] = true;
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return curr[2];
            }
            for (final int[] dir : dirs) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                int distance = 0;
                while (newX >= 0
                        && newY >= 0
                        && newX < maze.length
                        && newY < maze[0].length
                        && maze[newX][newY] == 0) {
                    newX += dir[0];
                    newY += dir[1];
                    distance++;
                }
                if (!visited[newX - dir[0]][newY - dir[1]]) {
                    q.offer(new int[]{newX - dir[0], newY - dir[1], curr[2] + distance});
                }
            }
        }
        return -1;
    }
}
