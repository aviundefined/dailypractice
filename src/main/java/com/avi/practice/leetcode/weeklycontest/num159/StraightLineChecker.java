package com.avi.practice.leetcode.weeklycontest.num159;

import com.avi.practice.utils.CommonUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class StraightLineChecker {
    private static final float PRECISION = 1.00F;

    static boolean isOnStraightLine(final List<Coordinate> coordinates) {
        // minimum two points required to be straight line
        if (CommonUtils.isEmpty(coordinates) || coordinates.size() < 2) {
            return false;
        }
        // two points are on always straight line
        if (coordinates.size() == 2) {
            return true;
        }
        // prepare line equation: y = mx + c
        // y - y1 = m * (x - x1)
        // m = (y2-y1) / (x2 - x1)
        // c = y1 - m * x1
        final Coordinate c1 = coordinates.get(0);
        final Coordinate c2 = coordinates.get(1);
        final float m = slope(c1, c2);
        final float c = constant(m, c1);
        for (int i = 2; i < coordinates.size(); i++) {
            if (!_isOnLine(coordinates.get(i), m, c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean _isOnLine(Coordinate coordinate, float m, float c) {
        return coordinate.y == ((m * coordinate.x) + c) * PRECISION;
    }

    private static float slope(final Coordinate c1, final Coordinate c2) {
        return ((c2.y - c1.y) / (c2.x - c1.x) * PRECISION);
    }

    private static float constant(final float slope, final Coordinate c1) {
        return (c1.y - (slope * c1.x)) * PRECISION;
    }

    static final class Coordinate {
        private final float x;
        private final float y;

        Coordinate(float x, float y) {
            this.x = x * PRECISION;
            this.y = y * PRECISION;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
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
