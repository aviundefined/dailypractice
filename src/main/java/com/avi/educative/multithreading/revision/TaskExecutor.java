package com.avi.educative.multithreading.revision;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 21/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TaskExecutor {

    private final Lock lock;
    private final Condition condition;
    private final PriorityQueue<Task> pq;
    private final Thread executor;

    public TaskExecutor() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.pq = new PriorityQueue<>((c1, c2) -> (int) (c1.startTimeInMillis - c2.startTimeInMillis));
        this.executor = new Thread(this::execute);
        this.executor.setDaemon(true);
    }

    public final void start() {
        this.executor.start();
    }

    public final void stop() {
        this.executor.interrupt();
    }

    public void register(final Task task) {
        lock.lock();
        try {
            pq.offer(task);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    private void execute() {
        while (true) {
            lock.lock();
            try {
                while (pq.isEmpty()) {
                    condition.await();
                }

                while (!pq.isEmpty()) {
                    final long sleep = (pq.peek().startTimeInMillis - System.currentTimeMillis());
                    if (sleep <= 0) {
                        break;
                    }
                    condition.await(sleep, TimeUnit.MILLISECONDS);
                }
                final Task task = pq.poll();
                _execute(task);
                lock.unlock();
            } catch (final InterruptedException ignore) {

            } finally {
                lock.unlock();
            }
        }
    }

    private void _execute(Task task) {
        System.out.println(task.message);
    }

    public static final class Task {
        private final long startTimeInMillis;
        private final String message;

        private Task(final int startAfterMillis, final String message) {
            this.startTimeInMillis = (startAfterMillis * 1000L) + System.currentTimeMillis();
            this.message = message;
        }
    }
}
