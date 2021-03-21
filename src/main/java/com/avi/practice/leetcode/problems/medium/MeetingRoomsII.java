package com.avi.practice.leetcode.problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        final PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            final int lastMeetingEndTime = endTimes.peek();
            final int currentMeetingEndTime = intervals[i][0];
            // if last meeting end time is before the current meeting start time then we can use the last room
            // so pop the last room end time and push the current meeting end time in heap
            if (currentMeetingEndTime >= lastMeetingEndTime) {
                endTimes.poll();
                endTimes.add(intervals[i][1]);
            } else {
                // new room is required
                endTimes.add(intervals[i][1]);
            }
        }
        return endTimes.size();
    }
}
