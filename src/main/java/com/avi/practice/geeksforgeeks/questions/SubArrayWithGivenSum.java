package com.avi.practice.geeksforgeeks.questions;

import java.util.Objects;

/**
 * Created by navinash on 22/12/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public final class SubArrayWithGivenSum {

    /*
     * Input: {1, 2, 3, 7, 5} , 12
     * Output: {2, 3, 7}
     */
    public StartEnd solve(final int[] arr, final int sum) {
        // Assumptions
        // 1) arr is not null
        // 2) arr is unsorted
        // 3) arr has only non-negative integers
        if (arr == null || arr.length == 0) {
            return null;
        }

        int s = 0;
        int e = 0;
        int currSum = arr[s];
        while (s <= e && e < arr.length - 1) {
            if (currSum == sum) {
                return new StartEnd(s, e);
            }
            if (currSum < sum) {
                e++;
                currSum = currSum + arr[e];
            } else //noinspection ConstantConditions
                if (currSum > sum) {
                    currSum = currSum - arr[s];
                    s++;
                }
        }
        return null;

    }

    public final static class StartEnd {
        private final int start;
        private final int end;

        public StartEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StartEnd startEnd = (StartEnd) o;
            return start == startEnd.start &&
                    end == startEnd.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "StartEnd{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
