package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by navinash on 09/06/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });


        final PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            final int[] interval = intervals[i];
            if(q.isEmpty()) {
                q.add(interval[1]);
                continue;
            }

            if (q.peek() > interval[0]) {
                q.add(interval[1]);
            } else {
                q.poll();
                q.add(interval[1]);
            }
        }
        return q.size();
    }
}
