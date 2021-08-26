package com.avi.practice.company.google;

import java.util.PriorityQueue;

/**
 * Created by navinash on 26/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class ProcessTasksUsingServers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        if (tasks == null) {
            return null;
        }

        final int numTasks = tasks.length;
        final int[] result = new int[numTasks];
        final PriorityQueue<Server> serverQueue = new PriorityQueue<>((a, b) -> {
            if (a.serverWeight != b.serverWeight) {
                return a.serverWeight - b.serverWeight;
            }
            return a.serverId - b.serverId;
        });
        for (int i = 0; i < servers.length; i++) {
            serverQueue.offer(new Server(i, servers[i]));
        }
        final PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> {
            if (t1.finishTime != t2.finishTime) {
                return t1.finishTime - t2.finishTime;
            }
            if (t1.serverWeight != t2.serverWeight) {
                return t1.serverWeight - t2.serverWeight;
            }
            if (t1.serverId != t2.serverId) {
                return t1.serverId - t2.serverId;
            }
            if (t1.enqueueTime != t2.enqueueTime) {
                return t1.enqueueTime - t2.enqueueTime;
            }

            return t1.taskId - t2.taskId;
        });

        int currentTime = 0;
        int numCompletedTask = 0;
        int taskNumber = 0;
        while (numCompletedTask < numTasks) {
            while (!taskQueue.isEmpty() && taskQueue.peek().finishTime <= currentTime) {
                final Task completedTask = taskQueue.poll();
                result[completedTask.taskId] = completedTask.serverId;
                serverQueue.offer(new Server(completedTask.serverId, completedTask.serverWeight));
                numCompletedTask++;
            }


            while (!serverQueue.isEmpty() && taskNumber <= currentTime && taskNumber < numTasks) {
                final Server server = serverQueue.poll();
                final Task inProgressTask = new Task(currentTime, currentTime + tasks[taskNumber], taskNumber, server.serverId, server.serverWeight);
                taskQueue.offer(inProgressTask);
                taskNumber++;
            }
            currentTime++;

        }
        return result;
    }

    private static final class Task {
        private final int enqueueTime;
        private final int finishTime;
        private final int taskId;
        private final int serverId;
        private final int serverWeight;

        public Task(int enqueueTime, int finishTime, int taskId, int serverId, int serverWeight) {
            this.enqueueTime = enqueueTime;
            this.finishTime = finishTime;
            this.taskId = taskId;
            this.serverId = serverId;
            this.serverWeight = serverWeight;
        }
    }

    private static final class Server {
        private final int serverId;
        private final int serverWeight;

        public Server(int serverId, int serverWeight) {
            this.serverId = serverId;
            this.serverWeight = serverWeight;
        }
    }
}
