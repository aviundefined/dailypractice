package com.avi.educative.multithreading.revision;

import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by navinash on 21/11/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class TaskExecutor implements ITaskExecutor {

    private final Lock lock;
    private final Condition condition;
    private final PriorityQueue<ITaskExecutor.Task> pq;
    private final Thread executor;
    private final ThreadPool pool;

    public TaskExecutor(final int maxConcurrentTasks) {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.pq = new PriorityQueue<>((c1, c2) -> (int) (c1.getStartTimeInMillis() - c2.getStartTimeInMillis()));
        this.executor = new Thread(this::execute);
        this.executor.setDaemon(true);
        // Forgot for now
        this.pool = new ThreadPool(maxConcurrentTasks);
    }

    public final void start() {
        this.executor.start();
        this.pool.start();
    }

    public final void stop() {
        this.executor.interrupt();
    }

    public void register(final ITaskExecutor.Task task) {
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
            ITaskExecutor.Task task = null;
            try {
                while (pq.isEmpty()) {
                    condition.await();
                }
                while (!pq.isEmpty()) {
                    final long sleep = getSleepTime(pq.peek());
                    if (sleep <= 0) {
                        break;
                    }
                    condition.await(sleep, TimeUnit.MILLISECONDS);
                }
                task = pq.poll();
            } catch (final InterruptedException ignored) {

            } finally {
                lock.unlock();
            }
            _execute(task);
        }
    }

    private long getSleepTime(Task peek) {
        return peek.getStartTimeInMillis() - System.currentTimeMillis();
    }

    private void _execute(ITaskExecutor.Task task) {
        this.pool.execute(task);
    }

    public static final class ThreadPool {
        private final LinkedBlockingDeque<ITaskExecutor.Task> queue = new LinkedBlockingDeque<>();
        private final Worker[] workers;

        private ThreadPool(final int size) {
            this.workers = new Worker[size];
            for (int i = 0; i < size; i++) {
                this.workers[i] = new Worker();
            }
        }

        public final void start() {
            for (Worker worker : this.workers) {
                worker.start();
            }
        }

        public final void execute(ITaskExecutor.Task task) {
            synchronized (queue) {
                queue.offer(task);
                queue.notify();
            }
        }

        private final class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    ITaskExecutor.Task task;
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            try {
                                wait();
                            } catch (InterruptedException ignored) {
                                // ignore so that it should be running
                            }
                        }
                        task = queue.poll();
                    }
                    try {
                        task.execute();
                    } catch (final Exception ignored) {
                        // ignore so that it should be running
                    }
                }
            }
        }
    }
}
