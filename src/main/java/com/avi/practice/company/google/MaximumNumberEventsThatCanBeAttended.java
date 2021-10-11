package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by navinash on 08/10/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class MaximumNumberEventsThatCanBeAttended {

    public int maxEvents(int[][] arr) {
        // attend ith event then can attend any event starting after ith event end time
        // if not attending ith event then can pick the next
        final int numEvents = arr.length;
        final Event[] events = new Event[numEvents];
        for (int i = 0; i < numEvents; i++) {
            events[i] = new Event(arr[i][0], arr[i][1]);
        }
        Arrays.sort(events, (a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });
        final int startDay = events[0].start;
        final int endDay = events[numEvents - 1].end;
        final PriorityQueue<Event> pq = new PriorityQueue<>((a, b) -> {
            return a.end - b.end;
        });
        int eventId = 0;
        int eventAttended = 0;
        for (int d = startDay; d <= endDay; d++) {
            while (eventId < numEvents && events[eventId].start <= d) {
                pq.offer(events[eventId]);
                eventId++;
            }

            while (!pq.isEmpty() && pq.peek().end < d) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                eventAttended++;
            }
        }
        return eventAttended;
    }


    private static final class Event {
        private final int start;
        private final int end;

        private Event(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }
}
