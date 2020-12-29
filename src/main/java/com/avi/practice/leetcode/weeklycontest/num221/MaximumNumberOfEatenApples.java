package com.avi.practice.leetcode.weeklycontest.num221;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Created by navinash on 28/12/20.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumNumberOfEatenApples {

    public int eatenApples(int[] apples, int[] days) {
        final PriorityQueue<RottenDayApples> q = new PriorityQueue<>();
        int day = 1;
        int i = 0;
        int numApples = 0;
        while (i < apples.length || !q.isEmpty()) {
            if (i < apples.length) {
                q.add(new RottenDayApples(day + days[i], apples[i]));
            }
            i++;
            while (!q.isEmpty() && q.peek().days <= day) {
                q.poll();
            }
            if (!q.isEmpty()) {
                final RottenDayApples top = q.poll();
                top.apples--;
                numApples++;
                if (top.apples > 0) {
                    q.add(top);
                }
            }
            day++;
        }

        System.out.println(q);
        return numApples;
    }

    private static final class RottenDayApples implements Comparable<RottenDayApples> {
        private final int days;
        private int apples;

        public RottenDayApples(int days, int apples) {
            this.days = days;
            this.apples = apples;
        }

        @Override
        public String toString() {
            return "(" + days + "," + apples + ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RottenDayApples that = (RottenDayApples) o;
            return days == that.days &&
                    apples == that.apples;
        }

        @Override
        public int hashCode() {
            return Objects.hash(days, apples);
        }

        @Override
        public int compareTo(RottenDayApples o) {
            return Integer.compare(this.days, o.days);
        }
    }
}
