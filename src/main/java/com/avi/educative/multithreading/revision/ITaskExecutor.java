package com.avi.educative.multithreading.revision;

/**
 * Created by navinash on 21/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public interface ITaskExecutor {

    void register(final Task task);
    void start();
    void stop();

    final class Task {
        private final long startTimeInMillis;
        private final Runnable runnable;

        private Task(final int startAfterMillis, final Runnable runnable) {
            this.startTimeInMillis = (startAfterMillis * 1000L) + System.currentTimeMillis();
            this.runnable = runnable;
        }

        public final long getStartTimeInMillis() {
            return startTimeInMillis;
        }

        public final void execute() {
            runnable.run();
        }
    }
}
