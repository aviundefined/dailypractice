package com.avi.practice.leetcode.problems.medium;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by navinash on 28/05/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) {
            return asteroids;
        }

        final Stack<Integer> s = new Stack<>();

        for (final int curr : asteroids) {
            if (s.isEmpty()) {
                s.push(curr);
                continue;
            }
            // 1) both are of same sign so can't collide, simply push
            // 2) peek is negative (moving in left) and current is positive (moving in right direction) so can't collide
            if ((s.peek() > 0 && curr > 0) // both positive - moving in right direction
                    || (s.peek() < 0 && curr < 0)  // both negative - moving in left direction
                    || (s.peek() < 0 && curr > 0) // left one is moving in left direction and right one is moving in right direction
            ) {
                s.push(curr);
                continue;
            }

            // now at this point s.peek() > 0 and curr < 0
            final int currAbs = Math.abs(curr);
            while (!s.isEmpty() && s.peek() > 0 && s.peek() < currAbs) {
                // remove all such elements which are moving in right direction and smaller than current which is moving in left
                s.pop();
            }
            if (!s.isEmpty()) {
                if (s.peek() > 0 && s.peek() == currAbs) {
                    s.pop();
                    continue;
                } else if (s.peek() > 0 && s.peek() > currAbs) {
                    continue;
                }
            }
            s.push(curr);
        }
        final int[] result = new int[s.size()];
        int i = s.size() - 1;
        while (!s.isEmpty()) {
            result[i--] = s.pop();
        }
        return result;
    }

    public int[] asteroidCollisionSlow(int[] asteroids) {
        final Map<Integer, Integer> elements = new TreeMap<>();
        final Stack<Pair> positives = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            final int a = asteroids[i];
            if (a > 0) {
                positives.push(new Pair(a, i));
                continue;
            }
            // got the negative number
            if (positives.isEmpty()) {
                elements.put(i, a);
                continue;
            }

            final Pair lastPositive = positives.peek();
            // if both last positive and current negative is equal in value then destroy both
            final int currentAbsolute = Math.abs(a);
            if (lastPositive.value == currentAbsolute) {
                positives.pop();
                continue;
            }
            // if last positive is greater then destroy the current negative
            if (lastPositive.value > currentAbsolute) {
                continue;
            }

            while (!positives.isEmpty() && positives.peek().value < currentAbsolute) {
                positives.pop();
            }

            if (!positives.isEmpty()) {
                // if both last positive and current negative is equal in value then destroy both
                if (positives.peek().value == currentAbsolute) {
                    positives.pop();
                    continue;
                } else if (positives.peek().value > currentAbsolute) {
                    continue;
                }
            }
            elements.put(i, a);
        }
        while (!positives.isEmpty()) {
            final Pair pair = positives.pop();
            elements.put(pair.index, pair.value);
        }
        final int[] result = new int[elements.size()];
        int i = 0;
        for (final Map.Entry<Integer, Integer> e : elements.entrySet()) {
            result[i] = e.getValue();
            i++;
        }
        return result;
    }

    private static final class Pair {
        private final int value;
        private final int index;

        private Pair(final int value, final int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
}
