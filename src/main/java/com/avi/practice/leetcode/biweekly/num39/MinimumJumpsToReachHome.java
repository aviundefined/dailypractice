package com.avi.practice.leetcode.biweekly.num39;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by navinash on 21/11/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * <p>
 * A certain bug's home is on the x-axis at position x. Help them get there from position 0.
 * <p>
 * The bug jumps according to the following rules:
 * <p>
 * It can jump exactly a positions forward (to the right).
 * It can jump exactly b positions backward (to the left).
 * It cannot jump backward twice in a row.
 * It cannot jump to any forbidden positions.
 * The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
 * <p>
 * Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * Output: 3
 * Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
 * Example 2:
 * <p>
 * Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * Output: -1
 * Example 3:
 * <p>
 * Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * Output: 2
 * Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * All the elements in forbidden are distinct.
 * Position x is not forbidden.
 */
public class MinimumJumpsToReachHome {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (a == 0) {
            return 0;
        }
        final int MAX = 10000;
        final int MIN = 0;
        final boolean[][] visited = new boolean[MAX][2]; // max value of x is 2000 and 2 states for reaching from back and front
        // add all forbidden in visited already
        for (final int val : forbidden) {
            visited[val][0] = true; // for front
            visited[val][1] = true; // for back
        }
        // start doing bfs
        final Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, false));
        while (!q.isEmpty()) {
            final Point curr = q.poll();
            final int direction = curr.isBack ? 1 : 0;
            if (visited[curr.x][direction]) {
                continue;
            }
            if (curr.x == x) {
                return curr.numSteps;
            }
            visited[curr.x][direction] = true;
            if (curr.x + a < MAX) {
                q.offer(new Point(curr.x + a, curr.numSteps + 1, false));
            }

            if (!curr.isBack && curr.x - b >= MIN) {
                q.offer(new Point(curr.x - b, curr.numSteps + 1, true));
            }
        }
        return -1;
    }

    private static final class Point {
        private final int x;
        private final int numSteps;
        private final boolean isBack;

        private Point(final int x, final int numSteps, final boolean isBack) {
            this.x = x;
            this.numSteps = numSteps;
            this.isBack = isBack;
        }
    }
}
