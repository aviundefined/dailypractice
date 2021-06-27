package com.avi.practice.company.google;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by navinash on 20/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class RangeModule {

    private final TreeMap<Integer, Range> map = new TreeMap<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        // find floor for both left and right
        final Map.Entry<Integer, Range> leftFloor = map.floorEntry(left);
        final Map.Entry<Integer, Range> rightFloor = map.floorEntry(right);
        final Range r = new Range();
        r.left = left;
        r.right = right;
        if (leftFloor != null) {
            // check if intersect
            if (isIntersecting(leftFloor.getValue().left, leftFloor.getValue().right, left, right)) {
                map.remove(leftFloor.getKey());
                r.left = leftFloor.getValue().left;
            }
        }
        if (rightFloor != null) {
            if (isIntersecting(rightFloor.getValue().left, rightFloor.getValue().right, left, right)) {
                map.remove(rightFloor.getKey());
                r.right = rightFloor.getValue().right;

            }
        }
        map.put(r.left, r);
    }

    public boolean queryRange(int left, int right) {
        return false;
    }

    public void removeRange(int left, int right) {
        // find floor for both left and right
        final Map.Entry<Integer, Range> leftFloor = map.floorEntry(left);
        final Map.Entry<Integer, Range> rightFloor = map.floorEntry(right);
        if(leftFloor == null && rightFloor == null) {
            return;
        }

        if(leftFloor != null && rightFloor != null) {
            if(isIntersecting(leftFloor.getValue().left, leftFloor.getValue().right, left, right)) {
                leftFloor.getValue().right = left;
            }
        }
    }

    private static boolean isIntersecting(final int left1, final int right1, final int left2, final int right2) {
        if(left2 >= left1 && left2 < right1) {
            return true;
        }
        if(left1 < right2 && right2 < right1) {
            return true;
        }
        return false;
    }
    private static final class Range {
        private int left;
        private int right;
    }
}
