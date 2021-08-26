package com.avi.practice.company.google;

import java.util.PriorityQueue;

/**
 * Created by navinash on 26/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ProcessTasksUsingServers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        if(tasks == null) {
            return null;
        }

        final int numTasks = tasks.length;
        final int[] result = new int[numTasks];
        // (index, weight)
        final PriorityQueue<int[]> serverQueue = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        // {server index, server weight, taskindex, finish time, eneueu time, taskNumer}
        final PriorityQueue<int[]> taskQueue = new PriorityQueue<>((a, b) -> {
            // first priority finish time
            if(a[2] != b[2]) {
                return a[2] - b[2];
            }
            // then server weight
            if(a[1] != b[1]) {
                return a[1] - b[1];
            }
            // then server index
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }

            // then task enque time
            return a[3] - b[3];
        });

        for(int i = 0; i < servers.length; i++) {
            serverQueue.offer(new int[] {i, servers[i]});
        }
        int currentTime = 0;
        int taskNumber = 0;
        while(taskNumber < numTasks) {
            while(!taskQueue.isEmpty() && taskQueue.peek()[2] <= currentTime) {
                final int[] completedTask = taskQueue.poll(); // complete the task
                // add the used server in available servers to work
                serverQueue.offer(new int[]{completedTask[0], completedTask[1]});
            }

            if(!serverQueue.isEmpty()) {
                // poll the available server and assign task
                final int[] server = serverQueue.poll();
                result[taskNumber] = server[0];
                taskQueue.offer(new int[]{server[0], server[1], tasks[taskNumber] + currentTime, currentTime});
                taskNumber++;

            }
            currentTime++;
        }
        return result;
    }
}
