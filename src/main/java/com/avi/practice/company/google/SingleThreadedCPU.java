package com.avi.practice.company.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by navinash on 30/07/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class SingleThreadedCPU {


    public int[] getOrder(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        final int n = arr.length;
        final Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            // (id, enqueueTime, processingTime)
            tasks[i] = new Task(i, arr[i][0], arr[i][1]);
        }
        // Sort array on enqueueTime
        Arrays.sort(tasks, Comparator.comparingInt(a -> a.enqueueTime));
        // Min heap based on processingTime then index
        final PriorityQueue<Task> q = new PriorityQueue<>((a, b) -> {
            if (a.processingTime == b.processingTime) {
                return a.id - b.id;
            }
            return a.processingTime - b.processingTime;
        });
        System.out.println(Arrays.toString(tasks));
        final int[] result = new int[n];
        int taskNumber = 0;
        int i = 0;
        int currentTime = 0;
        while (i < n) {
            // iterate over tasks and all the tasks whose enqueueTime <= currentTime
            while (taskNumber < n && tasks[taskNumber].enqueueTime <= currentTime) {
                q.offer(tasks[taskNumber++]);
            }

            // if still heap is empty then set the currentTime to first available enqueue time and try again
            if (q.isEmpty()) {
                currentTime = tasks[taskNumber].enqueueTime;
                continue;
            }
            final Task currTask = q.poll();
            result[i++] = currTask.id;
            currentTime += currTask.processingTime;
        }
        return result;
    }

    private static final class Task {
        private final int id;
        private final int enqueueTime;
        private final int processingTime;

        private Task(final int id, final int enqueueTime, final int processingTime) {
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }


        public String toString() {
            return "(id: " + id + ", enqueueTime: " + enqueueTime + ", processingTime: " + processingTime + ")";
        }
    }
}
