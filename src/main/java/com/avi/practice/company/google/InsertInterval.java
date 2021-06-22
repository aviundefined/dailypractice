package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by navinash on 21/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class InsertInterval {

    public int[][] insertV1(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            final int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        final int n = intervals.length;
        final int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[n][0] = newInterval[0];
        arr[n][1] = newInterval[1];

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        final Stack<int[]> s = new Stack<>();
        for (final int[] curr : arr) {
            if (s.isEmpty()) {
                s.push(curr);
                continue;
            }

            // intersecting, since array is sorted on start time so these are the possible cases
            // Case: 1
            //      s1------e1
            //          s2--------e2

            // Case: 2
            //       s1-----------e1
            //            s2----e2

            final int[] peek = s.peek();
            if (curr[0] > peek[1]) { // non intersecting push
                s.push(curr);
                continue;
            }
            final int[] toAdd = new int[2];
            toAdd[0] = peek[0];
            if (curr[1] > peek[1]) {
                toAdd[1] = curr[1];
            } else {
                toAdd[1] = peek[1];
            }
            s.pop();
            s.push(toAdd);
        }

        final int[][] result = new int[s.size()][2];
        int i = s.size() - 1;
        while (!s.isEmpty()) {
            final int[] curr = s.pop();
            result[i][0] = curr[0];
            result[i][1] = curr[1];
            i--;
        }

        return result;
    }

    public int[][] insertV2(int[][] intervals, int[] newInterval) {
        return insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            final int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        final int n = intervals.length;
        final Stack<int[]> s = new Stack<>();
        int idx = 0;
        while (idx < n && intervals[idx][0] < newInterval[0]) {
            s.push(intervals[idx]);
            idx++;
        }


        if(s.isEmpty() || s.peek()[1] < newInterval[0]) {
            s.push(newInterval);
        }else {
            final int[] toAdd  = s.pop();
            toAdd[1] = Math.max(newInterval[1], toAdd[1]);
            s.push(toAdd);
        }

        while (idx < n) {
            final int[] curr = intervals[idx];
            if (s.isEmpty()) {
                s.push(curr);
                idx++;
                continue;
            }

            // intersecting, since array is sorted on start time so these are the possible cases
            // Case: 1
            //      s1------e1
            //          s2--------e2

            // Case: 2
            //       s1-----------e1
            //            s2----e2

            final int[] peek = s.peek();
            if (curr[0] > peek[1]) { // non intersecting push
                s.push(curr);
                idx++;
                continue;
            }
            final int[] toAdd = new int[2];
            toAdd[0] = peek[0];
            if (curr[1] > peek[1]) {
                toAdd[1] = curr[1];
            } else {
                toAdd[1] = peek[1];
            }
            s.pop();
            s.push(toAdd);
            idx++;
        }

        final int[][] result = new int[s.size()][2];
        int i = s.size() - 1;
        while (!s.isEmpty()) {
            final int[] curr = s.pop();
            result[i][0] = curr[0];
            result[i][1] = curr[1];
            i--;
        }

        return result;
    }
}
