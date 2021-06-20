package com.avi.practice.company.google;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 * <p>
 * <p>
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 */
public class MaxPointsOnLine {

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            final Point p1 = new Point(points[i][0], points[i][1]);
            final Set<Point> visited = new HashSet<>();
            visited.add(p1);
            for (int j = 0; j < points.length; j++) {
                final Point p2 = new Point(points[j][0], points[j][1]);
                if (visited.contains(p2)) {
                    continue;
                }
                final double m = slope(p1, p2);
                final double c = intercept(p1, p2);
                visited.add(p2);
                int curr = 2;
                for (int k = 0; k < points.length; k++) {
                    final Point p = new Point(points[k][0], points[k][1]);
                    if (visited.contains(p)) {
                        continue;
                    }
                    if (isOnLine(p, m, c, p1)) {
                        visited.add(p);
                        curr++;
                    }
                }
                if (max < curr) {
                    max = curr;
                }
            }
        }

        return max;
    }

    private boolean isOnLine(final Point p, final double m, final double c, Point src) {
        if (m == Double.MAX_VALUE) {
            return src.x == p.x;
        }

        if (m == 0.0D) {
            return src.y == p.y;
        }
        final double y = m * p.x + c;
        return Double.compare(p.y * 1.00D, y) == 0;
    }

    private double slope(final Point p1, Point p2) {
        if (p1.x == p2.x) {
            return Double.MAX_VALUE;
        }

        if (p1.y == p2.y) {
            return 0.00D;
        }
        return ((p2.y - p1.y) * 1.00D) / (p2.x - p1.x);
    }

    private double intercept(final Point p1, final Point p2) {
        if (p1.x == p2.x) {
            return 0.00D;
        }
        if (p1.y == p2.y) {
            return p1.x * 1.00D;
        }
        final double m = slope(p1, p2);
        return (p1.y * 1.00D) - (m * p1.x);
    }

    private static final class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
