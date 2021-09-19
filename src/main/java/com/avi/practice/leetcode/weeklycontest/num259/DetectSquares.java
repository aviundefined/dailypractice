package com.avi.practice.leetcode.weeklycontest.num259;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by navinash on 19/09/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
class DetectSquares {

    private final Map<Point, Integer> points = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        this.points.compute(new Point(point[0], point[1]), (k, v) -> {
            if (v == null) {
                return 1;
            }
            return 1 + v;
        });
    }

    public int count(int[] point) {
        final int x = point[0];
        final int y = point[1];
        int count = 0;
        for (final Point dig : this.points.keySet()) {
            final int digX = dig.x;
            final int digY = dig.y;
            if (digX == x && digY == y) {
                continue;
            }
            if (Math.abs(digX - x) != Math.abs(digY - y)) {
                continue;
            }
            // check if (digX, y) && (x, digY) exist in map
            final int count1 = this.points.getOrDefault(new Point(digX, y), 0);
            final int count2 = this.points.getOrDefault(new Point(x, digY), 0);
            count += (count1 * count2 * this.points.getOrDefault(dig, 0));
        }
        return count;
    }

    private static final class Point {
        private final int x;
        private final int y;

        private Point(final int x, final int y) {
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
    }
}

