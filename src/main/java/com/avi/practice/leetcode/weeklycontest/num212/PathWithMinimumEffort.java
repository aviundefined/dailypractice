package com.avi.practice.leetcode.weeklycontest.num212;

/**
 * Created by navinash on 02/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 * Example 3:
 * <p>
 * <p>
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */
public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int start = 0;
        int end = getMaxHeight(heights);
        final int n = heights.length; // rows
        final int m = heights[0].length; // columns
        int minHeight = Integer.MAX_VALUE;
        while (start <= end) {
            final boolean[][] visited = new boolean[n][m];
            final int mid = start + (end - start) / 2;
            if (canReach(0, 0, n, m, mid, visited, heights)) {
                minHeight = Math.min(minHeight, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minHeight;
    }

    private int getMaxHeight(final int[][] heights) {
        int maxHeight = Integer.MIN_VALUE;
        final int n = heights.length;
        final int m = heights[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxHeight = Math.max(maxHeight, heights[i][j]);
            }
        }
        return maxHeight;
    }

    private boolean canReach(final int i, final int j, final int n, final int m, final int heightDiff, final boolean[][] visited, final int[][] heights) {
        if (i == n - 1 && j == m - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean canReach = false;

        if (i > 0 && !visited[i - 1][j] && Math.abs(heights[i - 1][j] - heights[i][j]) <= heightDiff) {
            canReach = canReach || canReach(i - 1, j, n, m, heightDiff, visited, heights);
        }
        if (j > 0 && !visited[i][j - 1] && Math.abs(heights[i][j - 1] - heights[i][j]) <= heightDiff) {
            canReach = canReach || canReach(i, j - 1, n, m, heightDiff, visited, heights);
        }
        if (i < n - 1 && !visited[i + 1][j] && Math.abs(heights[i + 1][j] - heights[i][j]) <= heightDiff) {
            canReach = canReach || canReach(i + 1, j, n, m, heightDiff, visited, heights);
        }
        if (j < m - 1 && !visited[i][j + 1] && Math.abs(heights[i][j + 1] - heights[i][j]) <= heightDiff) {
            canReach = canReach || canReach(i, j + 1, n, m, heightDiff, visited, heights);
        }
        return canReach;
    }
}
