package com.avi.practice.company.nutanix.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by navinash on 02/03/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MergeIntervals {


    public static void main(String[] args) {
        final MergeIntervals mergeIntervals = new MergeIntervals();
        final int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        mergeIntervals.merge(intervals);
    }

    /*
     * [[1,3],[2,6],[8,10],[15,18]]
     *
     * 1			3
     *      2			   6
     * 								8		10
     * 															15			18
     *
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        final Stack<int[]> s = new Stack<>();
        for (int i = intervals.length - 1; i >= 0; i--) {
            s.push(intervals[i]);
        }
        final List<int[]> merged = new ArrayList<>();
        merged.add(s.pop());
        while (!s.empty()) {
            final int[] last = merged.get(merged.size() - 1);
            final int[] pop = s.pop();
            // intersection so now merge
            if (last[1] >= pop[0]) {
                final int[] item = new int[2];
                item[0] = last[0];
                if (last[1] < pop[1]) {
                    // (1,3) (2,6) -> (1,6)
                    item[1] = pop[1];
                } else if (last[1] > pop[1]) {
                    // (1,5) (3,4) -> (1,5)
                    item[1] = last[1];
                } else {
                    // (1,4) (2, 4) -> (1,4)
                    item[1] = last[1];
                }
                merged.remove(merged.size() - 1);
                merged.add(item);
            } else {
                merged.add(pop);
            }
        }

        final int[][] convert = convert(merged);
        print(convert);
        return convert;
    }

    private int[][] convert(final List<int[]> list) {
        final int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arr[i][0] = list.get(i)[0];
            arr[i][1] = list.get(i)[1];
        }
        return arr;
    }

    private void print(final int[][] arr) {
        for (final int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
