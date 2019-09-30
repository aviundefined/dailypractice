package com.avi.paradigms.dp;

import com.avi.practice.utils.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by navinash on 29/09/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class MaxSurvivalArea {

    private final int powerA;
    private final int powerB;
    private final List<Area> areas = new ArrayList<>();
    private final int numAreas;
    private final Map<Key, Integer> solutions = new HashMap<>();

    MaxSurvivalArea(final int powerA, final int powerB, final List<Area> areas) {
        this.powerA = powerA;
        this.powerB = powerB;
        if (!CommonUtils.isEmpty(areas)) {
            this.areas.addAll(areas);
        }
        this.numAreas = this.areas.size();

    }

    int maxSurvival() {
        int maxSurvival = Integer.MIN_VALUE;
        for (int i = 0; i < numAreas; i++) {
            final Area area = this.areas.get(i);
            maxSurvival = Math.max(maxSurvival, _maxSurvival(powerA + area.a, powerB + area.b, i));
        }
        return maxSurvival;
    }

    private int _maxSurvival(final int powerA, final int powerB, final int lastArea) {
        if (powerA <= 0 || powerB <= 0) {
            return 0;
        }
        final Key key = new Key(powerA, powerB, lastArea);
        if (this.solutions.containsKey(key)) {
            return this.solutions.get(key);
        }
        int maxSurvival = Integer.MIN_VALUE;
        for (int i = 0; i < numAreas; i++) {
            // if same as last area then don't explore that
            if (i == lastArea) {
                continue;
            }
            final Area area = this.areas.get(i);
            maxSurvival = Math.max(_maxSurvival(powerA + area.a, powerB + area.b, i), maxSurvival);
        }
        this.solutions.put(key, 1 + maxSurvival);
        return 1 + maxSurvival;
    }

    static final class Area {
        private final int a;
        private final int b;

        Area(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    private static final class Key {
        private final int powerA;
        private final int powerB;
        private final int lastArea;

        private Key(int powerA, int powerB, int lastArea) {
            this.powerA = powerA;
            this.powerB = powerB;
            this.lastArea = lastArea;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return powerA == key.powerA &&
                    powerB == key.powerB &&
                    lastArea == key.lastArea;
        }

        @Override
        public int hashCode() {
            return Objects.hash(powerA, powerB, lastArea);
        }
    }
}
