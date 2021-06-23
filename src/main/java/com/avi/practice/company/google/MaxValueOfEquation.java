package com.avi.practice.company.google;

import java.util.PriorityQueue;

/**
 * You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
 * <p>
 * Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
 * <p>
 * It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
 * Output: 4
 * Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
 * No other pairs satisfy the condition, so we return the max of 4 and 1.
 * Example 2:
 * <p>
 * Input: points = [[0,0],[3,0],[9,2]], k = 3
 * Output: 3
 * Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= points.length <= 105
 * points[i].length == 2
 * -108 <= xi, yi <= 108
 * 0 <= k <= 2 * 108
 * xi < xj for all 1 <= i < j <= points.length
 * xi form a strictly increasing sequence.
 */
public class MaxValueOfEquation {

    public int findMaxValueOfEquation(int[][] points, int k) {
        final PriorityQueue<Tuple> q = new PriorityQueue<>((a, b)
                -> (a.yMinusX == b.yMinusX ? a.x - b.x : b.yMinusX - a.yMinusX));
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!q.isEmpty() && point[0] - q.peek().x > k) {
                q.poll();
            }
            if (!q.isEmpty()) {
                max = Math.max(max, q.peek().yMinusX + point[0] + point[1]);
            }
            q.offer(new Tuple(point[1] - point[0], point[0]));
        }
        return max;
    }

    private static final class Tuple {
        private final int yMinusX;
        private final int x;

        private Tuple(final int yMinusX, final int x) {
            this.yMinusX = yMinusX;
            this.x = x;
        }
    }


    public int findMaxValueOfEquationBruteForce(int[][] points, int k) {
        return bruteForce(points, k);
    }

    private int bruteForce(int[][] points, int k) {
        if (points == null || points.length <= 1) {
            return 0;
        }

        final int n = points.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                final int delta = Math.abs(points[i][0] - points[j][0]);
                if (delta <= k) {
                    final int val = points[i][1] + points[j][1] + delta;
                    max = Math.max(max, val);
                }
            }
        }
        return max;
    }
}
