package com.avi.practice.leetcode.weeklycontest.num159;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by navinash on 22/10/19.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
final class MaximumProfitJobScheduler {

    final int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(o -> o.end));
        final TreeMap<Integer, Integer> profitByEndTime = new TreeMap<>();
        profitByEndTime.put(jobs[0].end, jobs[0].profit);
        for (int i = 1; i < jobs.length; i++) {
            final Job job = jobs[i];
            // find that last job which end time is less than the start time of this job
            final Map.Entry<Integer, Integer> last = profitByEndTime.floorEntry(job.start);
            if (last != null) {
                profitByEndTime.put(job.end, Math.max(last.getValue() + job.profit, profitByEndTime.lastEntry().getValue()));
            } else {
                profitByEndTime.put(job.end, Math.max(job.profit, profitByEndTime.lastEntry().getValue()));
            }
        }
        return profitByEndTime.lastEntry().getValue();
    }


    private static final class Job {
        private final int start;
        private final int end;
        private final int profit;

        private Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    ", profit=" + profit +
                    '}';
        }
    }
}
