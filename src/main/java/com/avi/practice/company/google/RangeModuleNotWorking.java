package com.avi.practice.company.google;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RangeModuleNotWorking {

    private final TreeMap<Integer, Range> map = new TreeMap<>();

    public RangeModuleNotWorking() {

    }

    public void addRange(int left, int right) {
        // first get the segment intersecting with start
        final Map.Entry<Integer, Range> leftFloor = map.floorEntry(left);
        Range start = null;
        if (leftFloor != null && leftFloor.getValue().left <= left && left <= leftFloor.getValue().right) {
            start = leftFloor.getValue();
        }

        // get the entry intersecting with right
        final Map.Entry<Integer, Range> rightFloor = map.floorEntry(right);
        Range end = null;
        if (rightFloor != null && rightFloor.getValue().left <= right && right <= rightFloor.getValue().right) {
            end = rightFloor.getValue();
        }

        // no intersection range present in map
        if (start == null && end == null) {
            map.put(left, new Range(left, right));
            return;
        }


        if (start != null && end == null) {
            // merge start and current
            map.put(start.left, new Range(start.left, right));
            return;
        }

        if (start == null && end != null) {
            // merge start and current
            map.put(left, new Range(left, end.right));
            return;
        }

        final Range r = new Range(start.left, end.right);
        while (start != null && start.right <= end.right) {
            map.remove(start.left);
            final Map.Entry<Integer, Range> cielEntry = map.ceilingEntry(start.left);
            start = cielEntry == null ? null : cielEntry.getValue();
        }
        map.put(r.left, r);
    }

    public boolean queryRange(int left, int right) {
        final Map.Entry<Integer, Range> leftFloor = map.floorEntry(left);
        if (leftFloor == null) {
            return false;
        }

        final Range floor = leftFloor.getValue();
        if (floor.left <= left && floor.right >= right) {
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        // first get the segment intersecting with start
        final Map.Entry<Integer, Range> leftFloor = map.floorEntry(left);
        Range start = null;
        if (leftFloor != null && leftFloor.getValue().left <= left && left <= leftFloor.getValue().right) {
            start = leftFloor.getValue();
        }

        // get the entry intersecting with right
        final Map.Entry<Integer, Range> rightFloor = map.floorEntry(right);
        Range end = null;
        if (rightFloor != null && rightFloor.getValue().left <= right && right <= rightFloor.getValue().right) {
            end = rightFloor.getValue();
        }

        if (start == null && end == null) {
            return;
        }

        if (start != null && end == null) {
            map.remove(start.left);
            map.put(right, new Range(right, start.right));
            return;
        }

        if (start == null && end != null) {
            map.remove(end.left);
            map.put(end.left, new Range(end.left, left));
            return;
        }
        final Range first =  new Range(right, start.right);
        final Range last =  new Range(end.left, left);
        while (start != null && start.right <= end.right) {
            map.remove(start.left);
            final Map.Entry<Integer, Range> cielEntry = map.ceilingEntry(start.left);
            start = cielEntry == null ? null : cielEntry.getValue();
        }
        map.put(first.left, first);
        map.put(last.left, last);
    }

    private static final class Range {
        private final int left;
        private final int right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
