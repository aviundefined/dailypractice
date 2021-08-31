package com.avi.practice.company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by navinash on 31/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class JobSchedulingWithCoolOff {

    public String schedule(final String jobs, final int coolOff) {
        // aaacc, 1
        // aaacc, 2
        if (jobs == null || "".equals(jobs)) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        final PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.numJobs != b.numJobs) {
                return b.numJobs - a.numJobs;
            }
            return a.jobName.compareTo(b.jobName);
        });
        final Map<Character, Integer> freq = new HashMap<>();
        final Map<Character, Integer> canBeExecutedTime = new HashMap<>();
        for (final char c : jobs.toCharArray()) {
            freq.compute(c, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
            canBeExecutedTime.putIfAbsent(c, 0);
        }
        for (final Map.Entry<Character, Integer> e : freq.entrySet()) {
            pq.offer(new Job(e.getKey(), e.getValue()));
        }
        int currentTime = 0;
        while (!pq.isEmpty()) {
            final List<Job> rejectedJobs = new ArrayList<>();
            while (!pq.isEmpty() && canBeExecutedTime.getOrDefault(pq.peek().jobName, 0) > currentTime) {
                rejectedJobs.add(pq.poll());
            }
            currentTime++;
            if (pq.isEmpty()) {
                sb.append("_");
            } else {
                final Job scheduledJob = pq.poll();
                sb.append(scheduledJob.jobName);
                if (scheduledJob.numJobs > 1) {
                    scheduledJob.numJobs--;
                    pq.offer(scheduledJob);
                    canBeExecutedTime.put(scheduledJob.jobName, currentTime + coolOff);
                }
            }
            for (final Job rejectedJob : rejectedJobs) {
                pq.offer(rejectedJob);
            }

        }
        return sb.toString();
    }

    private static final class Job {
        private final Character jobName;
        private int numJobs;

        private Job(Character jobName, int numJobs) {
            this.jobName = jobName;
            this.numJobs = numJobs;
        }
    }
}
